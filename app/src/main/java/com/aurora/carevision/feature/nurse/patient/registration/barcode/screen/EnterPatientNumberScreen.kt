package com.aurora.carevision.feature.nurse.patient.registration.barcode.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.feature.nurse.patient.registration.barcode.SelfRegistrationViewModel

@Composable
fun EnterPatientNumberRoute(
    viewModel: SelfRegistrationViewModel = hiltViewModel(),
    navigateToCheckPatientInfo: () -> Unit = {},
    navigateToScanningBarcode: () -> Unit = {},
    navigateToBack: () -> Unit = {},
    patientNumber: String?,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    viewModel.updatePatientScanBarcode(patientNumber ?: "")

    EnterPatientNumberScreen(
        navigateToBack = navigateToBack,
        navigateToCheckPatientInfo = navigateToCheckPatientInfo,
        navigateToScanningBarcode = navigateToScanningBarcode,
        patientBarcodeNumber = state.patientBarcodeNumber,
        updatePatientScanBarcode = viewModel::updatePatientScanBarcode,
        getCheckPatientName = viewModel::getCheckPatientName,
    )
}

@Composable
fun EnterPatientNumberScreen(
    navigateToBack: () -> Unit = {},
    navigateToCheckPatientInfo: () -> Unit = {},
    navigateToScanningBarcode: () -> Unit = {},
    patientBarcodeNumber: String = "",
    updatePatientScanBarcode: (String) -> Unit = {},
    getCheckPatientName: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
    ) {
        TopAppBarLeft(
            onClick = { navigateToBack() },
            title = "환자 등록",
        )

        Text(
            text = "담당하는 환자 번호를\n입력해주세요",
            style = CVTheme.typography.headingPrimary,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 16.dp, start = 24.dp, bottom = 24.dp)
        )

        CVBasicTextField(
            value = patientBarcodeNumber,
            placeholder = "환자번호를 입력해주세요",
            label = "환자번호",
            onTextChanged = {
                updatePatientScanBarcode(it)
            },
            onFocusChanged = {},
            trailingIcon = R.drawable.ic_patient_register_line,
            onClickTailingIcon = navigateToScanningBarcode,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp),
        )

        CVLongButton(
            text = "다음",
            onClick = {
                navigateToCheckPatientInfo()
                getCheckPatientName()
            },
            enabled = true,
            modifier = Modifier
                .padding(top = 24.dp)
        )
    }
}

@Composable
@Preview
fun EnterPatientNumberScreenPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ) {
            EnterPatientNumberScreen(
                patientBarcodeNumber = "123351345"
            )
        }
    }
}
