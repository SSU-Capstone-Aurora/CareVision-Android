package com.aurora.carevision.feature.nurse.home

import android.util.Log
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.DefaultRenderersFactory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.offline.DownloadHelper.createMediaSource
import androidx.media3.exoplayer.rtsp.RtspMediaSource
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.ui.PlayerView
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.core.component.AdminVideoListItem
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.domain.nurse.model.streaming.SavedVideo
import com.aurora.carevision.feature.nurse.home.home.HomeViewModel

@Composable
fun LiveStreamingScreen(
    navigateToSavedVideoScreen: () -> Unit = {},
    onBackClick: () -> Unit = {},
    viewModel: HomeViewModel = hiltViewModel()
) {

    val state = viewModel.state.collectAsStateWithLifecycle().value

    LaunchedEffect(key1 = Unit) {
        viewModel.getSpecifyPatientStreamingUri(state.clickedPatientInfo?.patientId ?: -1)
    }

    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .background(Gray100),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val roomBedInfo = "${state.liveStreamingPatientInpatientWardNumber}동 ${state.liveStreamingPatientRoomNumber}호 ${state.liveStreamingPatientBedNumber}번 베드"
        val imageUrl = R.drawable.image_card_default.toString()

        val dummyList =
            listOf(
                SavedVideo(
                    videoId = 1,
                    videoUrl = imageUrl,
                    videoThumbnail = imageUrl,
                    videoPlayTime = "00:10",
                    videoDate = "2021.10.01",
                ),
                SavedVideo(
                    videoId = 2,
                    videoUrl = imageUrl,
                    videoThumbnail = imageUrl,
                    videoPlayTime = "00:10",
                    videoDate = "2021.10.01",
                ),
                SavedVideo(
                    videoId = 3,
                    videoUrl = imageUrl,
                    videoThumbnail = imageUrl,
                    videoPlayTime = "12:10",
                    videoDate = "2023.10.01",
                ),
                SavedVideo(
                    videoId = 4,
                    videoUrl = imageUrl,
                    videoThumbnail = imageUrl,
                    videoPlayTime = "00:10",
                    videoDate = "2021.10.01",
                ),
            )
        TopAppBarLeft(title = roomBedInfo, onClick = onBackClick)

        Log.d("LiveStreamingScreen", "state.clickedPatientInfo?.liveStreamingUrl: ${state.liveStreamingRtspUrl}")
        LiveStreamingViewScreen(
            rtspUri = state.liveStreamingRtspUrl,
            modifier =
            Modifier
                .height(250.dp)
                .padding(24.dp)
                .clip(RoundedCornerShape(8.dp)),
        )

        Text(
            text = "저장된 영상",
            style = CVTheme.typography.headingSecondary,
            color = Gray700,
            modifier =
            Modifier
                .padding(top = 16.dp, bottom = 8.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start,
        )

        LazyColumn(
            modifier = Modifier.padding(start = 24.dp, end = 24.dp),
        ) {
            items(dummyList) { savedVideo ->
                AdminVideoListItem(
                    imageUrl = savedVideo.videoThumbnail,
                    recordedDate = savedVideo.videoDate,
                    videoPlayTime = savedVideo.videoPlayTime,
                    onClick = {navigateToSavedVideoScreen()},
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@OptIn(UnstableApi::class)
@Composable
fun LiveStreamingViewScreen(
    rtspUri: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    // ExoPlayer 생성
    val player = remember { ExoPlayer.Builder(context).build() }

    LaunchedEffect(rtspUri) {
        try {
            // 코루틴을 사용해 RTSP MediaSource를 설정
            kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.Main) {
                val mediaSource: MediaSource = RtspMediaSource.Factory()
                    .setForceUseRtpTcp(true) // TCP 강제 사용
                    .setTimeoutMs(5000)      // 제한 시간 설정
                    .createMediaSource(MediaItem.fromUri(rtspUri))
                player.setMediaSource(mediaSource)
                player.prepare()
            }
            player.playWhenReady = true
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
fun LiveStreamingScreenPreview() {
    CVTheme {
        LiveStreamingScreen()
    }
}
