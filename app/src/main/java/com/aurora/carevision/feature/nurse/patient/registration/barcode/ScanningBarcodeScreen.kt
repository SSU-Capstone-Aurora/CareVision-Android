@file:OptIn(ExperimentalPermissionsApi::class)

package com.aurora.carevision.feature.nurse.patient.registration.barcode

import android.Manifest
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.FileProvider
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import java.io.File

@Composable
fun ScanningBarcodeScreen(
    onBarcodeScanned: (String) -> Unit = {},
    onScanError: (Exception) -> Unit = {},
    navigateToEnterPatientNumber: () -> Unit = {}
) {
    var photoUri by remember { mutableStateOf<Uri?>(null) }
    Log.d("ScanningBarcodeScreen", "$photoUri")

    val context = LocalContext.current
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success && photoUri != null) {
            val image = InputImage.fromFilePath(context, photoUri!!)
            Log.d("Scanned Barcode", "$image")

            scanBarcodes(
                image,
                onBarcodeScanned = { barcodes ->
                    barcodes.forEach { barcode ->
                        val barcodeValue = barcode.rawValue ?: "No value"
                        Log.d("Scanned Barcode",": $barcodeValue")
                        onBarcodeScanned(barcodeValue)
                        navigateToEnterPatientNumber()
                    }
                },
                onScanError = { exception ->
                    Log.d("Scanned Barcode", "Barcode scan failed: ${exception.message}")
                    onScanError(exception)
                }
            )
        }
    }

    val photoFile = File(context.cacheDir, "captured_image.jpg").apply {
        createNewFile()
    }
    photoUri = FileProvider.getUriForFile(context, "${context.packageName}.provider", photoFile)

    RequestCameraPermission {
        photoUri?.let { uri ->
            cameraLauncher.launch(uri)
        } ?: run {
            Log.d("Error: photoUri is null", "photoUri is null")
        }
    }
}

private fun scanBarcodes(
    image: InputImage,
    onBarcodeScanned: (List<Barcode>) -> Unit,
    onScanError: (Exception) -> Unit
) {
    val options = BarcodeScannerOptions.Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_QR_CODE,
            Barcode.FORMAT_AZTEC,
            Barcode.FORMAT_CODE_128,
            Barcode.FORMAT_EAN_13
        )
        .build()

    val scanner = BarcodeScanning.getClient(options)

    scanner.process(image)
        .addOnSuccessListener { barcodes ->
            Log.d("바코드 개수",": ${barcodes.size}") // 바코드 개수 확인
            onBarcodeScanned(barcodes)
        }
        .addOnFailureListener { exception ->
            onScanError(exception)
        }
}


@Composable
fun RequestCameraPermission(onPermissionGranted: () -> Unit) {
    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

    // Check the permission state and act accordingly
    LaunchedEffect(cameraPermissionState.status.isGranted) {
        if (cameraPermissionState.status.isGranted) {
            onPermissionGranted()
        } else {
            cameraPermissionState.launchPermissionRequest()
        }
    }

    if (!cameraPermissionState.status.isGranted) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("카메라 권한이 필요합니다.")
            Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                Text("권한 요청")
            }
        }
    }
}