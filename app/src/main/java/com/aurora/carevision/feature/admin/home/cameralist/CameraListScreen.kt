package com.aurora.carevision.feature.admin.home.cameralist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.core.component.AdminCameraListItem
import com.aurora.carevision.core.component.CVHeadIconSearchBar

@Composable
fun CameraListScreen(
    viewModel: CameraListViewModel= hiltViewModel()
) {
    //val dummyCameraList = listOf("2동 301호 3번 베드")
    val state = viewModel.state.collectAsState().value
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.getAdminCameraList()
    }

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
        items(state.cameraList) { camera ->
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

    CVTheme{
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ){
            CameraListScreen()
        }
    }
}