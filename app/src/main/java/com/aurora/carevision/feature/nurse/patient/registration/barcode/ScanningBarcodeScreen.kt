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
    // 카메라로 찍은 사진의 변수를 저장
    Log.d("ScanningBarcodeScreen", "photo Uri : $photoUri")

    val context = LocalContext.current
    // rememberLauncherForActivityResult 함수를 사용하여 ActivityResultContract를 사용하여 카메라 앱을 실행
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success && photoUri != null) { // 사진이 찍히면
            val image = InputImage.fromFilePath(context, photoUri!!)
            // 사진을 InputImage로 변환 (ML Kit에서 사용하는 이미지 형식)
            Log.d("ScanningBarcodeScreen", "Scanned Barcode : $image")

            scanBarcodes(
                image,
                onBarcodeScanned = { barcodes ->
                    barcodes.forEach { barcode ->
                        val barcodeValue = barcode.rawValue ?: "No value"
                        Log.d("ScanningBarcodeScreen",": Scanned Barcode in Scan Function : $barcodeValue")
                        onBarcodeScanned(barcodeValue) // 바코드 값이 있으면 onBarcodeScanned 함수 실행
                        navigateToEnterPatientNumber() // 성공 시 환자 번호 입력 화면으로 이동
                    }
                },
                onScanError = { exception ->
                    Log.d("ScanningBarcodeScreen", "Barcode scan failed: ${exception.message}")
                    onScanError(exception)
                }
            )
        }
    }

    val photoFile = File(context.cacheDir, "captured_image.jpg").apply {
        createNewFile()
    }
    // photoFile 변수에 캐시 디렉토리에 captured_image.jpg 파일 생성
    // 이 코드가 필요한 이유는 카메라 앱이 파일을 저장할 때 파일 경로를 제공해야 하기 때문
    photoUri = FileProvider.getUriForFile(context, "${context.packageName}.provider", photoFile)
    // photoUri 변수에 FileProvider를 사용하여 파일의 Uri를 저장

    // 카메라 권한 요청
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
            Barcode.FORMAT_QR_CODE, // QR 코드
            Barcode.FORMAT_AZTEC, // 아즈텍 코드
            Barcode.FORMAT_CODE_128, // 코드 128
            Barcode.FORMAT_EAN_13 // EAN-13
        )
        .build()

    val scanner = BarcodeScanning.getClient(options)

    scanner.process(image)
        // 성공 시
        .addOnSuccessListener { barcodes ->
            Log.d("ScanningBarcodeScreen","barcode size: ${barcodes.size}") // 사진 업로드 디버깅
            onBarcodeScanned(barcodes)
        }
        // 실패 시
        .addOnFailureListener { exception ->
            onScanError(exception)
        }
}


// 카메라 권한 요청
@Composable
fun RequestCameraPermission(onPermissionGranted: () -> Unit) {
    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
    // com.google.accompanist.permissions 사용하여 카메라 권한 요청
    // Manifest.permission.CAMERA 권한을 요청하고 결과를 cameraPermissionState에 저장

    // 권한 확인 후 권한이 허용되면 onPermissionGranted() 함수 실행
    LaunchedEffect(cameraPermissionState.status.isGranted) {
        if (cameraPermissionState.status.isGranted) {
            onPermissionGranted()
        } else {
            cameraPermissionState.launchPermissionRequest()
            // launchPermissionRequest 함수도 com.google.accompanist.permissions 라이브러리에 포함되어 있음
        }
    }

    // 권한 요청 버튼 표시
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