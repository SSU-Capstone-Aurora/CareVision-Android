package com.aurora.carevision.feature.nurse.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.core.component.AdminVideoListItem
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.domain.nurse.video.SavedVideo

@Composable
fun VideoDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val roomBedInfo = "101호 1번 베드"
        val imageUrl = "https://www.example.com/image.jpg"
        val dummyList = listOf(
            SavedVideo(
                videoId = 1,
                videoUrl = "",
                videoThumbnail = "",
                videoPlayTime = "00:10",
                videoDate = "2021.10.01"
            ),
            SavedVideo(
                videoId = 2,
                videoUrl = "",
                videoThumbnail = "",
                videoPlayTime = "00:10",
                videoDate = "2021.10.01"
            ),
            SavedVideo(
                videoId = 3,
                videoUrl = "",
                videoThumbnail = "",
                videoPlayTime = "12:10",
                videoDate = "2023.10.01"
            ),
            SavedVideo(
                videoId = 4,
                videoUrl = "",
                videoThumbnail = "",
                videoPlayTime = "00:10",
                videoDate = "2021.10.01"
            )
        )
        TopAppBarLeft(title = roomBedInfo)

        AsyncImage(
            model = imageUrl,
            contentDescription = "Live Video thumbnail",
            placeholder = painterResource(id = R.drawable.image_card_default),
            error = painterResource(id = R.drawable.image_card_default),
            modifier = Modifier
                .width(312.dp)
                .height(178.dp)
                .padding(top = 24.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "저장된 영상",
            style = CVTheme.typography.headingSecondary,
            color = Gray700,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 8.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        LazyColumn(
            modifier = Modifier.padding(start = 24.dp, end = 24.dp)
        ) {
            items(dummyList) { savedVideo ->
                AdminVideoListItem(
                    imageUrl = savedVideo.videoThumbnail,
                    recordedDate = savedVideo.videoDate,
                    videoPlayTime = savedVideo.videoPlayTime,
                    onClick = {}//TODO
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
@Preview
fun VideoDetailScreenPreview() {
    CVTheme {
        LiveVideoScreen()
    }
}