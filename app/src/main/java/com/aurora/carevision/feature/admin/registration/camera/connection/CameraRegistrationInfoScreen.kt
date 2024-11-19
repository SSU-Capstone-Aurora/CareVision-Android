package com.aurora.carevision.feature.admin.registration.camera.connection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft

@Composable
fun CameraRegistrationInfoScreen(
    navigateToCheckCameraInfo: () -> Unit = {},
    navigateToScanningBarcode: () -> Unit = {},
    navigateToBack: () -> Unit = {},
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
    ) {
        TopAppBarLeft(
            onClick = { navigateToBack() },
            title = "장치 추가",
        )

        Text(
            text = "카메라 등록을 위한\n정보를 입력해주세요",
            style = CVTheme.typography.headingPrimary,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 16.dp, start = 24.dp, bottom = 24.dp)
        )

        var text by remember { mutableStateOf("") } // TODO Move To viewModel
        var wardText by remember { mutableStateOf("") }
        var roomText by remember { mutableStateOf("") }
        var bedText by remember { mutableStateOf("") }

        CVBasicTextField(
            value = wardText,
            placeholder = "입원 병동 번호를 입력해주세요",
            label = "입원 병동",
            onTextChanged = { newValue -> wardText = newValue },
            onFocusChanged = {},
            //trailingIcon = R.drawable.ic_patient_register_line,
            //onClickTailingIcon = navigateToScanningBarcode,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp),
        )
        val isDigitError = wardText.any { !it.isDigit() } // TODO Move To viewModel
        Box(modifier = Modifier.height(30.dp)) {
            if (isDigitError) {
                Text(
                    text = "잘못된 입력 형식입니다.",
                    color = Red600,
                    style = CVTheme.typography.captionRegular,
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .fillMaxWidth()
                )
            }
        }

        CVBasicTextField(
            value = roomText,
            placeholder = "입원실 번호를 입력해주세요",
            label = "입원실 번호",
            onTextChanged = { newValue -> roomText = newValue },
            onFocusChanged = {},
            //trailingIcon = R.drawable.ic_patient_register_line,
            //onClickTailingIcon = navigateToScanningBarcode,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp),
        )
        Box(modifier = Modifier.height(30.dp)) {
            if (roomText.isEmpty()) {
                Text(
                    text = "*필수",
                    color = Red600,
                    style = CVTheme.typography.captionRegular,
                    modifier = Modifier
                        .padding(start = 24.dp, top = 4.dp)
                        .fillMaxWidth()
                )
            }
        }

        CVBasicTextField(
            value = bedText,
            placeholder = "베드 번호를 입력해주세요",
            label = "베드 번호",
            onTextChanged = { newValue -> bedText = newValue },
            onFocusChanged = {},
            //trailingIcon = R.drawable.ic_patient_register_line,
            //onClickTailingIcon = navigateToScanningBarcode,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp),
        )
        Box(modifier = Modifier.height(30.dp)) {
            if (bedText.isEmpty()) {
                Text(
                    text = "*필수",
                    color = Red600,
                    style = CVTheme.typography.captionRegular,
                    modifier = Modifier
                        .padding(start = 24.dp, top = 4.dp)
                        .fillMaxWidth()
                )
            }
        }
        CVLongButton(
            text = "다음",
            //onClick = navigateToCheckPatientInfo,
            onClick = {},
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
            CameraRegistrationInfoScreen()
        }
    }
}
