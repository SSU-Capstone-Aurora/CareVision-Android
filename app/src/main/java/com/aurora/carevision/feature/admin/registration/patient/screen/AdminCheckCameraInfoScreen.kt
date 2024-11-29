package com.aurora.carevision.feature.admin.registration.patient.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray600
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.domain.nurse.model.Camera

@Composable
fun AdminCheckCameraInfoScreen(
    navigateToDone: () -> Unit = {},
    onClickBack: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){
        val patientName = "오로라"
        val cameraName = Camera(
            cameraCode = "07-FJw144",
            inpatientWardNumber = 2,
            patientRoomNumber = 101,
            bedNumber = 4,
        )

        TopAppBarLeft("환자 등록", onClick = onClickBack)

        Spacer(modifier = Modifier.height(28.dp).weight(0.5f))

        Text(
            text = "등록할 환자의\n정보를 확인해주세요",
            style = CVTheme.typography.headingPrimary,
            color = Gray700,
            modifier = Modifier
                .padding(start = 24.dp, bottom = 24.dp)
        )

        Spacer(modifier = Modifier.height(28.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .background(White)
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "환자명",
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray500,
                )

                Text(
                    text = "$patientName",
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray600,
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "베드 정보",
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray500,
                )

                Text(
                    text = "${cameraName.bedNumber}",
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray600,
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "카메라",
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray500,
                    modifier = Modifier
                )

                Text(
                    text = "${cameraName.patientRoomNumber}",
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray600,
                    modifier = Modifier
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        CVLongButton(
            text = "확인",
            onClick = navigateToDone,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(28.dp).weight(1f))
    }
}

@Composable
@Preview
fun CheckCameraInfoScreenPreview(){
    CVTheme{
        AdminCheckCameraInfoScreen()
    }
}

