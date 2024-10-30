package com.aurora.carevision.feature.admin.auth.registration.camera

import android.graphics.Paint.Align
import android.graphics.drawable.PaintDrawable
import android.service.controls.Control
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.TestModifierUpdaterLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Gray600
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminCameraListItem
import com.aurora.carevision.core.component.AdminNurseListItem
import com.aurora.carevision.core.component.AdminHospitalListItem
import com.aurora.carevision.core.component.AdminPatientListItem
import com.aurora.carevision.core.component.CVBasicButton
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVHeadIconSearchBar
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVTabs
import com.aurora.carevision.core.component.TopAppBarLeft


@Composable
fun CameraRegistScreen(){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
    ) {
        TopAppBarLeft(
            title = "장치 추가",
        )

        Text(
            text = "      해당 기기를\n등록하시겠습니까?",
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
                    text = "일련 번호     7C0AA49AAZ116FC", //TODO 일련 번호, string style 다르게 해야함
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
            onClick = {},
            modifier = Modifier
                .padding(top = 100.dp)
        )
    }
}



@Composable
@Preview
fun ListScreenPreview(){

    CVTheme{
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ){
            CameraRegistScreen()
        }
    }
}




