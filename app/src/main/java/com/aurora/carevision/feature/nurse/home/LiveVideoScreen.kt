package com.aurora.carevision.feature.nurse.home

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
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.core.component.VideoNavigationBar

@Composable
fun LiveVideoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val roomBedInfo = "101호 1번 베드"
        val videoTime = "2024.07.05 10:08"
        TopAppBarLeft(title = roomBedInfo)
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
        LiveVideoScreen()
    }
}