package com.aurora.carevision.feature.admin.registration.patient.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.core.component.AdminCameraListItem
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.domain.nurse.model.Camera

@Composable
fun AdminCameraListScreen(
    onClickCheckFinishInfo: () -> Unit = {},
    onClickNavigateToBack: () -> Unit = {}
) {
    var selectedCameraId by remember { mutableStateOf<String?>(null) }

    val dummyList = listOf(
        Camera(
          cameraCode = "07-FJw144",
            inpatientWardNumber = 2,
            patientRoomNumber = 101,
            bedNumber = 4,
        ),
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
    ) {
        TopAppBarLeft("환자 등록", onClick = onClickNavigateToBack)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 26.dp, start = 24.dp, end = 24.dp)
        ) {
            Text(
                text = "연결할 환자를 선택해주세요",
                color = Gray700,
                style = CVTheme.typography.headingSecondary,
                modifier = Modifier
            )
            Text(
                text = "사용 중이지 않은 카메라만 조회됩니다",
                color = Gray500,
                style = CVTheme.typography.textBody2Medium,
                modifier = Modifier
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .weight(2f)
        ) {
            items(dummyList) { camera ->
                AdminCameraListItem(
                    cameraInfo = "${camera.patientRoomNumber}호",
                    cameraId = camera.cameraCode,
                    isSelected = selectedCameraId == camera.cameraCode,
                    onClick = {
                        selectedCameraId =
                            if (selectedCameraId == camera.cameraCode) null else camera.cameraCode
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        CVLongButton(
            text = "다음",
            onClick = { onClickCheckFinishInfo() },
            enabled = selectedCameraId != null,
            modifier = Modifier.padding(bottom = 15.dp)
        )
    }
}

@Composable
@Preview
fun PreviewCameraListScreen() {
    CVTheme {
        AdminCameraListScreen()
    }
}