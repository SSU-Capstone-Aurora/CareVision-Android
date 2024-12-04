package com.aurora.carevision.feature.nurse.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.core.component.VideoNavigationBar
import com.aurora.carevision.feature.nurse.home.home.HomeViewModel

@Composable
fun SavedVideoScreen(
    onBackClick: () -> Unit = {},
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val roomBedInfo = "${state.clickedPatientInfo?.inpatientWardNumber ?: ""}동 ${state.clickedPatientInfo?.patientRoomNumber ?: ""}호 ${state.clickedPatientInfo?.bedNumber ?: ""}번 베드"
        val videoTime = "2024.07.05 10:08"
        TopAppBarLeft(title = roomBedInfo, onClick = onBackClick)
        Spacer(modifier = Modifier.height(24.dp))
        VideoNavigationBar(videoSavedDateTime = videoTime)
        Spacer(modifier = Modifier.height(24.dp))

        // TODO 영상 스트리밍 UI 추가
    }
}

@Composable
@Preview
fun LiveVideoScreenPreview() {
    CVTheme{
        SavedVideoScreen()
    }
}