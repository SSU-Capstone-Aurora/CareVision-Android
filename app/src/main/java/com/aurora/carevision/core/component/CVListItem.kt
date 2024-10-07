package com.aurora.carevision.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Gray400
import com.aurora.carevision.app.ui.theme.Green500
import com.aurora.carevision.app.ui.theme.White
@Composable
fun AdminPatientListItem(
    name: String,
    patientInfo: String,
    patientId: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp), //텍스트랑 아이콘 사이 공간?인듯함
            verticalArrangement = Arrangement.Center
        ) {
            // 환자 이름
            Text(
                text = name,
                style = CVTheme.typography.textBody1Importance,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )
            // 환자 정보
            Text(
                text = patientInfo,
                style = CVTheme.typography.textBody1Medium,
                color = Gray400,
                maxLines = 1, // 있어야겠죠..? 없어도되나요ㅜ
                overflow = TextOverflow.Ellipsis,
            )
        }
        Text(
            text = patientId,
            style = CVTheme.typography.captionRegular,
            color = Green500,
            textAlign = TextAlign.End,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}
@Composable
fun AdminNurseListItem(
    name: String,
    modifier: Modifier = Modifier,
    profileIcon: Int = R.drawable.ic_profile_frame_32, // 프로필 아이콘
    onDeleteClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // 프로필 사진
        Image(
            painter = painterResource(id = profileIcon),
            contentDescription = "Profile Icon",
            modifier = Modifier
                .size(48.dp) // 사진 크기 조절
                .padding(end = 12.dp)
        )
        // 이름 텍스트
        Text(
            text = name,
            style = CVTheme.typography.textBody1Importance,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )

        // 삭제 버튼
        Box(modifier = Modifier.align(Alignment.CenterVertically)) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_listdeletebutton_45x32),
                contentDescription = "Delete Icon",
                modifier = Modifier
                    .size(36.dp)
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
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) { Image(
        painter = painterResource(id = cameraIcon),
        contentDescription = "Camera Icon",
        modifier = Modifier
            .size(48.dp)
            .padding(end = 12.dp)
    )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // 환자 이름
            Text(
                text = cameraInfo,
                style = CVTheme.typography.textBody1Importance,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )
            // 환자 정보
            Text(
                text = cameraId,
                style = CVTheme.typography.textBody1Medium,
                color = Gray400,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
fun AdminRequestItem(
    name: String,
    requestTime: String,
    onAcceptClick: () -> Unit = {},
    onRejectClick: () -> Unit = {},
    rejectIcon: Int = R.drawable.ic_nurserequest_reject_30x30,
    acceptIcon: Int = R.drawable.ic_nurserequest_accept_30x30,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                style = CVTheme.typography.textBody1Importance,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = requestTime,
                style = CVTheme.typography.textBody1Medium,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

        Row {
            // x버튼
            Image(
                painter = painterResource(id = rejectIcon),
                contentDescription = "Reject Icon",
                modifier = Modifier
                    .size(36.dp)
                    .padding(end = 12.dp))
            // 체크 버튼
            Image(
                painter = painterResource(id = acceptIcon),
                contentDescription = "Accept Icon",
                modifier = Modifier
                    .size(36.dp)
                    .padding(end = 12.dp))
        }
    }
}

@Composable
fun AdminVideoListItem(
    Date: String,
    Time: String,
    modifier: Modifier = Modifier,
    VideoIcon: Int = R.drawable.ic_video_frame_90x52, // 비디오 아이콘..이긴 한데 영상 썸네일 느낌으로 캡쳐한 사진이 들어가게 하는건 어떻게 설정하는지 모르겠습니다..
    //VideoIcon 이 친구는 figma에서 알려주신대로 사진 다운로드 받아서 사용해보니 url 오류가 나와서 일단 빈칸으로 해뒀습니다!
    onMoveClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = VideoIcon),
            contentDescription = "Video Icon",
            modifier = Modifier
                .size(48.dp)
                .padding(end = 12.dp)
        )
        Column (
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp),
            verticalArrangement = Arrangement.Center
        )
            {
            Text(
                text = Date,
                style = CVTheme.typography.textBody1Importance,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = Time,
                style = CVTheme.typography.textBody1Medium,
                color = Gray400,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Box(modifier = Modifier.align(Alignment.CenterVertically)) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_backrightbutton_video_24x25),
                contentDescription = "Arrow Icon",
                modifier = Modifier
                    .size(24.dp)
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
            modifier = Modifier.background(White),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AdminPatientListItem(
                name = "강레오",
                patientInfo = "입원병동(옵션) | 입원실 | 베드 번호",
                patientId = "환자 번호"
            )
            AdminNurseListItem(
                name = "강레오",
                onDeleteClick = {}
            )
            AdminCameraListItem(
                cameraInfo = "입원병동 입원실 베드",
                cameraId = "123456789"
            )
            AdminRequestItem(
                name = "최강록",
                requestTime = "어제"
            )
            AdminVideoListItem(
                Date ="2024.10.08",
                Time ="10:08",
                onMoveClick = {}
            )
        }

    }
}
