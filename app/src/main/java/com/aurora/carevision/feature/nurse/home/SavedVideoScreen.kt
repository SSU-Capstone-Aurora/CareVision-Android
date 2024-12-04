package com.aurora.carevision.feature.nurse.home

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.rtsp.RtspMediaSource
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
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

    LaunchedEffect(key1 = Unit) {
        viewModel.getSpecifyPatientSavedVideoUri(state.clickedSavedVideoId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val roomBedInfo = "${state.clickedPatientInfo?.inpatientWardNumber ?: ""}동 ${state.clickedPatientInfo?.patientRoomNumber ?: ""}호 ${state.clickedPatientInfo?.bedNumber ?: ""}번 베드"
        val videoTime = "${state.clickedSavedVideoDate}"
        TopAppBarLeft(title = roomBedInfo, onClick = onBackClick)
        Spacer(modifier = Modifier.height(24.dp))
        VideoNavigationBar(videoSavedDateTime = videoTime)
        Spacer(modifier = Modifier.height(24.dp))

        // TODO 영상 스트리밍 UI 추가
        ExoPlayerView(
            context = LocalContext.current,
            videoUri = state.specifyPatientSavedVideoUri,
            modifier = Modifier.height(250.dp)
        )

    }
}

@androidx.annotation.OptIn(UnstableApi::class)
@Composable
fun ExoPlayerView(
    context: Context,
    videoUri: String,
    modifier: Modifier = Modifier
) {

    // ExoPlayer 생성
    val player = remember { ExoPlayer.Builder(context).build() }

    LaunchedEffect(videoUri) {
        try {
            // HTTP 영상을 위한 MediaItem 설정
            kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.Main) {
                val mediaItem = MediaItem.fromUri(Uri.parse(videoUri))
                player.setMediaItem(mediaItem)
                player.prepare()
            }
            player.playWhenReady = true // 자동 재생
        } catch (e: Exception) {
            Log.e("ExoPlayer", "Error setting up player", e)
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            // ExoPlayer 리소스 해제
            player.stop()
            player.release()
        }
    }

    // PlayerView를 AndroidView로 연결
    AndroidView(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        factory = { ctx ->
            PlayerView(ctx).apply {
                this.player = player
            }
        }
    )
}


@Composable
@Preview
fun LiveVideoScreenPreview() {
    CVTheme{
        SavedVideoScreen()
    }
}