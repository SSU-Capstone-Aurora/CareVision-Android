package com.aurora.carevision.feature.admin.home.cameralist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminCameraListItem
import com.aurora.carevision.core.component.CVHeadIconSearchBar
import com.aurora.carevision.domain.admin.model.camera.Camera

@Composable
fun CameraListRoute(
    viewModel: CameraListViewModel= hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    LaunchedEffect(key1 = Unit) {
        viewModel.getAdminCameraList()
    }

    CameraListScreen( cameraList = state.cameraList )
    
}

@Composable
fun CameraListScreen(
    cameraList: List<Camera> = emptyList(),
){
    Spacer(modifier = Modifier.height(8.dp))
    CVHeadIconSearchBar(
        value = "",
        onValueChange = {},
        placeholder = "카메라 위치를 검색해주세요",
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(8.dp))

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(cameraList) { camera ->
            AdminCameraListItem(
                cameraId = camera.cameraId,
                cameraInfo = "${camera.inpatientWardNumber}동 ${camera.patientRoomNumber}호 ${camera.bedNumber}번 베드",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
@Preview
fun CameraListScreenPreview(){

    val dummyCameraList = listOf(
        Camera(
            cameraId = "1",
            inpatientWardNumber = 121,
            patientRoomNumber = 22,
            bedNumber = 19
        ),
        Camera(
            cameraId = "1",
            inpatientWardNumber = 121,
            patientRoomNumber = 22,
            bedNumber = 19
        ),
        Camera(
            cameraId = "1",
            inpatientWardNumber = 121,
            patientRoomNumber = 22,
            bedNumber = 19
        ),
        Camera(
            cameraId = "1",
            inpatientWardNumber = 121,
            patientRoomNumber = 22,
            bedNumber = 19
        ),

    )
    CVTheme{
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ){
            CameraListScreen(
                cameraList = dummyCameraList
            )
        }
    }
}