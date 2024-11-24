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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray600
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.feature.admin.home.navigation.AdminHome
import com.aurora.carevision.feature.admin.registration.camera.CameraRegistrationSideEffect
import com.aurora.carevision.feature.admin.registration.camera.CameraRegistrationViewModel


@Composable
fun CameraRegistFinishScreen(
    viewModel: CameraRegistrationViewModel = hiltViewModel(),
    onFinish: () -> Unit = {},
    navigateToBack: () ->Unit= {},
){

    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is CameraRegistrationSideEffect.NavigatetoHome -> AdminHome

                else -> {}
            }
        }
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
    ) {
        TopAppBarLeft(
            onClick = navigateToBack,
            title = "장치 추가",
        )

        Text(
            text = "      카메라와 베드를\n다음과 같이 연결합니다",
            style = CVTheme.typography.headingPrimary,
            color = Black,
            modifier = Modifier
                .padding(top = 92.dp, start = 24.dp, end = 24.dp)
                .align(Alignment.CenterHorizontally)
        )
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ){

            Box(
                modifier = Modifier
                    .size(312.dp, 132.dp)
                    .offset(y = 100.dp)
                    .background(Color.White, shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = """
                        일련 번호   ${state.cameraSerialNumber}
                        베드 정보    ${state.wardNumber}동 ${state.roomNumber}호 ${state.bedNumber}번
                    """.trimIndent(),

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
            text = "확인",
            onClick = {
                viewModel.submitToServer()
                onFinish()
            },
            modifier = Modifier
                .padding(top = 100.dp)
        )
    }
}



@Composable
@Preview
fun CameraRegistFinishScreenPreview(){
    CVTheme{
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ){
            CameraRegistFinishScreen()
        }
    }
}




