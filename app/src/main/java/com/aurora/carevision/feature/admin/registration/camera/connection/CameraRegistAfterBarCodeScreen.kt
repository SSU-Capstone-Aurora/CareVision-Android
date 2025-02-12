package com.aurora.carevision.feature.admin.registration.camera.connection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray600
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.feature.admin.registration.camera.CameraRegistrationSideEffect
import com.aurora.carevision.feature.admin.registration.camera.CameraRegistrationViewModel


@Composable
fun CameraRegisterAfterBarCodeRoute(
    viewModel: CameraRegistrationViewModel = hiltViewModel(),
    navigateToInfo: () -> Unit,
    navigateToBack: () -> Unit
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is CameraRegistrationSideEffect.NavigateToInfo -> navigateToInfo()
                is CameraRegistrationSideEffect.NavigateToBack -> navigateToBack()
                else -> {}
            }
        }
    }

    CameraRegisterAfterBarCodeScreen(
        navigateToBack = navigateToBack,
        navigateToInfo = navigateToInfo,
        serialNumber = state.cameraSerialNumber,
        updateSerialNumber = { state.cameraSerialNumber = it }
    )

}

@Composable
fun CameraRegisterAfterBarCodeScreen(
    navigateToBack: () -> Unit = {},
    navigateToInfo: () -> Unit = {},
    serialNumber: String = "",
    updateSerialNumber: (String) -> Unit = {}
) {
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
            text = "해당 기기를\n등록하시겠습니까?",
            style = CVTheme.typography.headingPrimary,
            color = Black,
            modifier = Modifier
                .padding(top = 92.dp, start = 24.dp, end = 24.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .size(312.dp, 132.dp)
                    .offset(y = 100.dp)
                    .background(Color.White, shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = serialNumber,
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray600
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_ip_camera),
                contentDescription = "IpCamera",
                modifier = Modifier
                    .size(180.dp)

            )
        }
        CVLongButton(
            text = "다음",
            onClick = {
                updateSerialNumber(serialNumber)
                navigateToInfo()
            },
            modifier = Modifier
                .padding(top = 100.dp)
        )
    }
}


@Composable
@Preview
fun ListScreenPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ) {
            CameraRegisterAfterBarCodeScreen(
                serialNumber = "A-123"
            )
        }
    }
}




