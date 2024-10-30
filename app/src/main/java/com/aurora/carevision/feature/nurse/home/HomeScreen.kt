package com.aurora.carevision.feature.nurse.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray600
import com.aurora.carevision.app.ui.theme.Primary600
import com.aurora.carevision.app.ui.theme.White

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    hasAlarm: Boolean = false
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(start = 12.dp, end = 12.dp, top = 24.dp, bottom = 12.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "환자 영상", style = CVTheme.typography.headingDisplay, color = Black)
            Image(
                painter = painterResource(id = if (hasAlarm) R.drawable.ic_alarm_active else R.drawable.ic_alarm),
                contentDescription = "Alarm"
            )
        }



        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
        ) {
            items(50) {
                VideoCardView(onClickCard = {})
            }
        }


    }
}

@Composable
fun VideoCardView(
    onClickCard: () -> Unit,
    modifier: Modifier = Modifier,
    roomBedInfo: String = "101호 1번 침대",
    imageUrl: String = "",
    patientName: String = "김철수",
    hasAlarm: Boolean = true
) {
    Card(
        onClick = onClickCard,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        
        Column(
            modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(White)
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Video Thumbnail",
                modifier = Modifier.height(84.dp).fillMaxWidth(),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.image_card_default),
                error = painterResource(id = R.drawable.image_card_default)
            )

            Row(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if(hasAlarm) {
                    Image(painter = painterResource(id = R.drawable.ic_alarm_circle_red), contentDescription = "has alarm", modifier = Modifier.padding(end = 4.dp))
                }

                Text(text = roomBedInfo, style = CVTheme.typography.textBody2Importance, color = Gray600)
            }
            Text(text = patientName, style = CVTheme.typography.captionImportance, color = Gray500, modifier = Modifier.padding(start = 12.dp, bottom = 12.dp))
        }


    }
}


@Composable
@Preview
fun HomeScreenPreview() {
    CVTheme {
        HomeScreen()
    }
}

@Composable
@Preview
fun VideoCardViewPreview() {
    CVTheme {
        VideoCardView(onClickCard = {})
    }
}