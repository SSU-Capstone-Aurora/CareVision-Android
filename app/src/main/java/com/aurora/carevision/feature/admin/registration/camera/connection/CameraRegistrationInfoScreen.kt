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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.feature.admin.registration.camera.CameraRegistrationSideEffect
import com.aurora.carevision.feature.admin.registration.camera.CameraRegistrationViewModel

@Composable
fun CameraRegistrationInfoScreen(
    viewModel: CameraRegistrationViewModel = hiltViewModel(),
    navigateToFinish: () -> Unit = {},
    navigateToScanningBarcode: () -> Unit = {},
    navigateToBack: () -> Unit = {},
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is CameraRegistrationSideEffect.NavigateToFinish -> navigateToFinish()
                is CameraRegistrationSideEffect.NavigateToBack -> navigateToBack()
                else -> {}
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
    ) {
        TopAppBarLeft(
            onClick = navigateToBack,
            title = "장치 추가",
        )

        Text(
            text = "카메라 등록을 위한\n정보를 입력해주세요",
            style = CVTheme.typography.headingPrimary,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 16.dp, start = 24.dp, bottom = 24.dp)
        )

        CVBasicTextField(
            value = state.wardNumber?: "",
            placeholder = "입원 병동 번호를 입력해주세요",
            label = "입원 병동",
            onTextChanged = { newValue -> viewModel.updateWardNumber(newValue)},
            onFocusChanged = {},
            //trailingIcon = R.drawable.ic_patient_register_line,
            //onClickTailingIcon = navigateToScanningBarcode,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
        )
//        Box(modifier = Modifier.height(30.dp)) {
//            if (state.wardNumber == null) {
//                Text(
//                    text = "잘못된 입력 형식입니다.",
//                    color = Red600,
//                    style = CVTheme.typography.captionRegular,
//                    modifier = Modifier
//                        .padding(horizontal = 24.dp, vertical = 8.dp)
//                        .fillMaxWidth()
//                )
//            }
//        }

        CVBasicTextField(
            value = state.roomNumber?: "",
            placeholder = "입원실 번호를 입력해주세요",
            label = "입원실 번호",
            onTextChanged = { newValue -> viewModel.updateRoomNumber(newValue)},
            onFocusChanged = {},
            //trailingIcon = R.drawable.ic_patient_register_line,
            //onClickTailingIcon = navigateToScanningBarcode,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp),
        )
        Box(modifier = Modifier.height(30.dp)) {
            if (state.roomNumber == "") {
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
            value = state.bedNumber?: "",
            placeholder = "베드 번호를 입력해주세요",
            label = "베드 번호",
            onTextChanged = { newValue -> viewModel.updateBedNumber(newValue)},
            onFocusChanged = {},
            //trailingIcon = R.drawable.ic_patient_register_line,
            //onClickTailingIcon = navigateToScanningBarcode,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp),
        )
        Box(modifier = Modifier.height(30.dp)) {
            if (state.bedNumber == "") {
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
            onClick = navigateToFinish,
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
