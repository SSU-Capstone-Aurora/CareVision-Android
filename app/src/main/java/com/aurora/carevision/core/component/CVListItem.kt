package com.aurora.carevision.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray400
import com.aurora.carevision.app.ui.theme.Primary500
import com.aurora.carevision.app.ui.theme.White

@Composable
fun AdminPatientListItem(
    patientName: String,
    patientInfo: String,
    patientId: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(White),
            //.padding(.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // 환자 이름
            Text(
                text = patientName,
                style = CVTheme.typography.textBody1Importance,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, top = 5.dp)
            )
            // 환자 정보
            Text(
                text = patientInfo,
                style = CVTheme.typography.textBody1Medium,
                color = Gray400,
                maxLines = 1, // 있어야겠죠..? 없어도되나요ㅜ
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 12.dp, bottom = 5.dp)
            )
        }
        Text(
            text = patientId,
            style = CVTheme.typography.captionRegular,
            color = Primary500,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 12.dp)
        )
    }
}

@Composable
fun AdminNurseListItem(
    nurseName: String,
    modifier: Modifier = Modifier,
    profileIcon: Int = R.drawable.ic_profile_frame_32, // 프로필 아이콘
    onDeleteClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // 프로필 사진
        Image(
            painter = painterResource(id = profileIcon),
            contentDescription = "Profile Icon",
            modifier = Modifier
                .size(48.dp) // 사진 크기 조절
                .background(White)
                .padding(start = 12.dp)
        )
        // 이름 텍스트
        Text(
            text = nurseName,
            style = CVTheme.typography.textBody1Importance,
            color = Color.Black,
            modifier = Modifier
                .weight(1f)
                .background(White)
                .padding(start = 12.dp)
        )

        // 삭제 버튼
        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .background(White)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_listdeletebutton_45x32),
                contentDescription = "Delete Icon",
                modifier = Modifier
                    .size(48.dp)
                    .background(White)
                    .padding(end = 12.dp)
                    .clickable(onClick = onDeleteClick),
            )
        }
    }
}

@Composable
fun AdminCameraListItem(
    cameraInfo: String,
    cameraId: String,
    modifier: Modifier = Modifier,
    cameraIcon: Int = R.drawable.ic_cameralistitem_42x42, //이 친구는 figma에서 알려주신대로 사진 다운로드 받아서 사용해보니 url 오류가 나와서 일단 빈칸으로 해뒀습니다!
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = cameraIcon),
            contentDescription = "Camera Icon",
            modifier = Modifier
                .size(48.dp)
                .padding(start = 12.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .background(White)
                .padding(end = 16.dp, top = 5.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // 환자 이름
            Text(
                text = cameraInfo,
                style = CVTheme.typography.textBody1Importance,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, top = 5.dp)
            )
            // 환자 정보
            Text(
                text = cameraId,
                style = CVTheme.typography.textBody1Medium,
                color = Gray400,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, bottom = 5.dp)
            )
        }
    }
}

@Composable
fun AdminRequestItem(
    nurseRequestName: String,
    requestTime: String,
    onAcceptClick: () -> Unit = {},
    onRejectClick: () -> Unit = {},
//    rejectIcon: Int = R.drawable.ic_nurserequest_reject_30x30,
//    acceptIcon: Int = R.drawable.ic_nurserequest_accept_30x30,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = nurseRequestName,
                style = CVTheme.typography.textBody1Importance,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, top = 5.dp)
            )

            Text(
                text = requestTime,
                style = CVTheme.typography.textBody1Medium,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier
                    .padding(start = 12.dp, bottom = 5.dp)
            )
        }

        Row {
            // x버튼
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_nurserequest_reject_30x30),
                contentDescription = "Reject Icon",
                modifier = Modifier
                    .size(36.dp)
                    .padding(end = 12.dp)
            )
            // 체크 버튼
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_nurserequest_accept_30x30),
                contentDescription = "Accept Icon",
                modifier = Modifier
                    .size(36.dp)
                    .padding(end = 12.dp)
            )
        }
    }
}

@Composable
fun AdminVideoListItem(
    date: String,
    time: String,
    modifier: Modifier = Modifier,
    videoIcon: Int = R.drawable.ic_video_frame_90x52, // 비디오 아이콘..이긴 한데 영상 썸네일 느낌으로 캡쳐한 사진이 들어가게 하는건 어떻게 설정하는지 모르겠습니다..
    //VideoIcon 이 친구는 figma에서 알려주신대로 사진 다운로드 받아서 사용해보니 url 오류가 나와서 일단 빈칸으로 해뒀습니다!
    onMoveClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = videoIcon),
            contentDescription = "Video Icon",
            modifier = Modifier
                .size(96.dp)
                .padding(start = 12.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .background(White)
                .padding(end = 16.dp),
            verticalArrangement = Arrangement.Center
        )
        {
            Text(
                text = date,
                style = CVTheme.typography.textBody1Importance,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
            )
            Text(
                text = time,
                style = CVTheme.typography.textBody1Medium,
                color = Gray400,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 12.dp)
            )
        }
        Box(modifier = Modifier.align(Alignment.CenterVertically)) {
            Image(
                painter = painterResource(id = R.drawable.ic_backrightbutton_video_24x25),
                contentDescription = "Arrow Icon",
                modifier = Modifier
                    .size(36.dp)
                    .padding(end = 12.dp)
                    .clickable(onClick = onMoveClick),
            )
        }
    }
}

@Preview
@Composable
fun AdminPatientListItemPreview() {
    CVTheme {
        Column(
            modifier = Modifier.background(Black),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AdminPatientListItem(
                patientName = "강레오",
                patientInfo = "입원병동(옵션) | 입원실 | 베드 번호",
                patientId = "환자 번호"
            )
            AdminNurseListItem(
                nurseName = "강레오",
                onDeleteClick = {}
            )
            AdminCameraListItem(
                cameraInfo = "입원병동 입원실 베드",
                cameraId = "123456789"
            )
            AdminRequestItem(
                nurseRequestName = "최강록",
                requestTime = "어제"
            )
            AdminVideoListItem(
                date = "2024.10.08",
                time = "10:08",
                onMoveClick = {}
            )
        }

    }
}
