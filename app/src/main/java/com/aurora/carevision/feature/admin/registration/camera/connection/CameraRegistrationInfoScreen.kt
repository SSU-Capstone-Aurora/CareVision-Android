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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
fun CameraRegistrationInfoRoute(
    viewModel: CameraRegistrationViewModel = hiltViewModel(),
    navigateToFinish: () -> Unit = {},
    navigateToBack: () -> Unit = {},
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is CameraRegistrationSideEffect.NavigateToFinish -> navigateToFinish()
                is CameraRegistrationSideEffect.NavigateToBack -> navigateToBack()
                else -> {}
            }
        }
    }

    CameraRegistrationInfoScreen(
        navigateToBack = navigateToBack,
        navigateToFinish = navigateToFinish,
        wardNumber = state.wardNumber,
        roomNumber = state.roomNumber,
        bedNumber = state.bedNumber,
        updateWardNumber = { viewModel.updateWardNumber(it) },
        updateRoomNumber = { viewModel.updateRoomNumber(it) },
        updateBedNumber = { viewModel.updateBedNumber(it) }
    )
    
}

@Composable
fun CameraRegistrationInfoScreen(
    navigateToBack: () -> Unit = {},
    navigateToFinish: () -> Unit = {},
    wardNumber: String? = "",
    roomNumber: String? = "",
    bedNumber: String? = "",
    updateWardNumber: (String) -> Unit = {},
    updateRoomNumber: (String) -> Unit = {},
    updateBedNumber: (String) -> Unit = {},
){
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
                .padding(top = 16.dp, start = 24.dp, bottom = 24.dp),
            textAlign = TextAlign.Start
        )

        CVBasicTextField(
            value = wardNumber?: "",
            placeholder = "입원 병동 번호를 입력해주세요",
            label = "입원 병동",
            onTextChanged = { newValue -> updateWardNumber(newValue)},
            onFocusChanged = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
        )

        CVBasicTextField(
            value = roomNumber?: "",
            placeholder = "입원실 번호를 입력해주세요",
            label = "입원실 번호",
            onTextChanged = { newValue -> updateRoomNumber(newValue)},
            onFocusChanged = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp),
        )
        Box(modifier = Modifier.height(30.dp)) {
            if (roomNumber.isNullOrBlank()) {
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
            value = bedNumber?: "",
            placeholder = "베드 번호를 입력해주세요",
            label = "베드 번호",
            onTextChanged = { newValue -> updateBedNumber(newValue)},
            onFocusChanged = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp),
        )
        Box(modifier = Modifier.height(30.dp)) {
            if (bedNumber.isNullOrBlank()) {
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
fun CameraRegistrationInfoScreenPreview() {
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
