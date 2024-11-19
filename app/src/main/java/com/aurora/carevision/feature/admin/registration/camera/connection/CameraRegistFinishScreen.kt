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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray600
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft


@Composable
fun CameraRegistFinishScreen(){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
    ) {
        TopAppBarLeft(
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
                    text = "일련 번호   7C0AA49AAZ116FC\n베드 정보    2동 201호 4번", //TODO

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
            onClick = {},
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




