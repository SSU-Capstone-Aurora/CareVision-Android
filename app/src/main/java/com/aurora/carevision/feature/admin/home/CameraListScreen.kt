package com.aurora.carevision.feature.admin.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.core.component.AdminCameraListItem
import com.aurora.carevision.core.component.CVHeadIconSearchBar

@Composable
fun CameraListScreen() {
    val dummyCameraList = listOf("2동 301호 3번 베드")

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
        items(dummyCameraList) { info ->
            AdminCameraListItem(
                cameraInfo = info,
                cameraId = "7C0AA49AAZ116FC",
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