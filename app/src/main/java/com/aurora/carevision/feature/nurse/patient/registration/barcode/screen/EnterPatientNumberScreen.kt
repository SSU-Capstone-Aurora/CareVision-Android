package com.aurora.carevision.feature.nurse.patient.registration.barcode.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft

@Composable
fun EnterPatientNumberScreen(
    navigateToCheckPatientInfo: () -> Unit = {},
    navigateToScanningBarcode: () -> Unit = {},
    navigateToBack: () -> Unit = {},
    patientNumber: String?,
) {
    Log.d("EnterPatientNumberScreen", "patientNumber : $patientNumber")

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

        var text by remember { mutableStateOf("") } // TODO Move To viewModel


        CVBasicTextField(
            value = text,
            placeholder = "환자번호를 입력해주세요",
            label = "환자번호",
            onTextChanged = {
                text = it
            },
            onFocusChanged = {},
            trailingIcon = R.drawable.ic_patient_register_line,
            onClickTailingIcon = navigateToScanningBarcode,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp),
        )


        val isLoginError = true // TODO Move To viewModel
        if (isLoginError) {
            Text(
                text = "*아직 등록되지 않은 환자입니다",
                color = Red600,
                style = CVTheme.typography.captionRegular,
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 8.dp)
                    .fillMaxWidth()
            )
        }

        CVLongButton(
            text = "다음",
            onClick = navigateToCheckPatientInfo,
            enabled = true,
            modifier = Modifier
                .padding(top = 24.dp)
        )
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ) {
            EnterPatientNumberScreen(patientNumber = "123456")
        }
    }
}
