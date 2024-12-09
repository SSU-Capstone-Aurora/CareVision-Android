package com.aurora.carevision.feature.nurse.home.home

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray600
import com.aurora.carevision.app.ui.theme.White
import kotlinx.coroutines.flow.collect

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToSpecificPatientStreaming: () -> Unit = {},
    navigateToNotificationList: () -> Unit = {},
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    val context = LocalContext.current

    // 알림 권한 요청
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Toast.makeText(context, "알림 권한이 허용되었습니다.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "알림 권한이 거부되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.getPatientStreamingList()
        viewModel.getNotificationList()
        viewModel.getNurseMypageInfo()
    }

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect{ sideEffect ->
            when(sideEffect) {
                is HomeSideEffect.GetPatientStreamingListSuccess -> {
                    // Handle success
                }
                is HomeSideEffect.GetPatientStreamingListFailure -> {
                    // Handle failure
                }
                else -> {}
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(start = 12.dp, end = 12.dp, top = 24.dp, bottom = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "환자 영상", style = CVTheme.typography.headingDisplay, color = Black)
            Image(
                painter = painterResource(id = if (state.notificationList.isNotEmpty()) R.drawable.ic_alarm_active else R.drawable.ic_alarm),
                contentDescription = "Alarm",
                modifier = modifier.clickable {
                    navigateToNotificationList()
                }
            )
        }



        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier.fillMaxSize(),
        ) {
            items(state.patientStreamingList.size) {
                VideoCardView(
                    onClickCard = {
                        navigateToSpecificPatientStreaming()
                        viewModel.updateClickedPatientInfo(state.patientStreamingList[it])
                                  },
                    patientName = state.patientStreamingList[it].patientName,
                    imageUrl = state.patientStreamingList[it].thumbnailImage,
                    inpatientWardNumber = state.patientStreamingList[it].inpatientWardNumber.toString(),
                    patientRoomNumber = state.patientStreamingList[it].patientRoomNumber.toString(),
                    bedNumber = state.patientStreamingList[it].bedNumber.toString()
                )
            }
        }


    }
}

@Composable
fun VideoCardView(
    onClickCard: () -> Unit,
    modifier: Modifier = Modifier,
    inpatientWardNumber: String = "",
    patientRoomNumber: String = "",
    bedNumber: String = "",
    imageUrl: String = "",
    patientName: String = "",
    hasAlarm: Boolean = true
) {
    Card(
        onClick = onClickCard,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        
        Column(
            modifier = modifier
                .clip(RoundedCornerShape(8.dp))
                .background(White)
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Video Thumbnail",
                modifier = modifier
                    .height(84.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.image_card_default),
                error = painterResource(id = R.drawable.image_card_default),
                onError = { error ->
                    Log.e("AsyncImage", "Image load failed: ${error.result.throwable}")
                }
            )


            Row(
                modifier = modifier.padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if(hasAlarm) {
                    Image(painter = painterResource(id = R.drawable.ic_alarm_circle_red), contentDescription = "has alarm", modifier = Modifier.padding(end = 4.dp))
                }

                Text(text = "${inpatientWardNumber}동 ${patientRoomNumber}호 ${bedNumber}침대", style = CVTheme.typography.textBody2Importance, color = Gray600)
            }
            Text(text = patientName, style = CVTheme.typography.captionImportance, color = Gray500, modifier = Modifier.padding(start = 12.dp, bottom = 12.dp))
        }


    }
}


@Composable
@Preview
private fun HomeScreenPreview() {
    CVTheme {
        HomeScreen()
    }
}

@Composable
@Preview
private fun VideoCardViewPreview() {
    CVTheme {
        VideoCardView(onClickCard = {})
    }
}