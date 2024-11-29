package com.aurora.carevision.feature.nurse.patient.registration.barcode.screen

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.core.component.AdminCameraListItem
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.domain.nurse.model.Camera
import com.aurora.carevision.feature.nurse.patient.registration.barcode.SelfRegistrationViewModel

@Composable
fun CameraListScreen(
    onClickCheckFinishInfo: () -> Unit = {},
    onClickNavigateToBack: () -> Unit = {},
    viewModel: SelfRegistrationViewModel = hiltViewModel()
) {
    var selectedCameraId by remember { mutableStateOf<String?>(null) }

    val state = viewModel.state.collectAsState().value

    LaunchedEffect(key1 = Unit) {
        viewModel.getUnlinkedCameras()
    }

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
            items(state.cameraList) { camera ->
                AdminCameraListItem(
                    cameraInfo = "${camera.inpatientWardNumber} 병동 ${camera.patientRoomNumber}호실 ${camera.bedNumber}번 침대",
                    cameraId = camera.cameraCode,
                    isSelected = selectedCameraId == camera.cameraCode,
                    onClick = {
                        selectedCameraId =
                            if (selectedCameraId == camera.cameraCode) null else camera.cameraCode
                        viewModel.selectedCameraInfo(
                            cameraCode = camera.cameraCode,
                            inpatientWardNumber = camera.inpatientWardNumber,
                            patientRoomNumber = camera.patientRoomNumber,
                            bedNumber = camera.bedNumber
                        )
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
        CameraListScreen()
    }
}