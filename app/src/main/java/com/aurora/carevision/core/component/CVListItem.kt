package com.aurora.carevision.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import coil3.compose.AsyncImage
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray200
import com.aurora.carevision.app.ui.theme.Gray400
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray600
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
                .background(White)
                .padding(vertical = 12.dp, horizontal = 16.dp),
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
                style = CVTheme.typography.captionImportance,
                color = Gray400,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 12.dp, bottom = 5.dp)
            )
        }
        Text(
            text = patientId,
            style = CVTheme.typography.captionImportance,
            color = Primary500,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.Top)
                .padding(end = 12.dp, top = 16.dp)
        )
    }
}

@Composable
fun AdminNurseListItem(
    nurseName: String,
    nurseId: String,
    modifier: Modifier = Modifier,
    profileIcon: Int = R.drawable.ic_profile_frame_32, // 프로필 아이콘
    onDeleteClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 12.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // 프로필 사진
        Image(
            painter = painterResource(id = profileIcon),
            contentDescription = "Profile Icon",
            modifier = Modifier
                .width(48.dp) // 사진 크기 조절
                .background(White)
                .padding(start = 16.dp)
        )
        // 이름 텍스트

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(end = 16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = nurseName,
                style = CVTheme.typography.textBody1Importance,
                color = Color.Black,
                modifier = Modifier.padding(start = 12.dp)
            )

            Text(
                text = nurseId,
                style = CVTheme.typography.captionImportance,
                color = Gray500,
                modifier = Modifier.padding(start = 12.dp)
            )
        }

        // 삭제 버튼
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

@Composable
fun AdminCameraListItem(
    cameraInfo: String,
    cameraId: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 12.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_ip_camera),
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
                color = Gray600,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, top = 5.dp)
            )
            // 환자 정보
            Text(
                text = cameraId,
                style = CVTheme.typography.captionImportance,
                color = Gray500,
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
    nurseId: String,
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
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = nurseRequestName,
                style = CVTheme.typography.headingSecondary,
                color = Gray600,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, top = 5.dp)
            )

            Text(
                text = nurseId,
                style = CVTheme.typography.captionImportance,
                color = Gray500,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier
                    .padding(start = 12.dp, bottom = 5.dp)
            )

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(Gray200)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "요청시간",
                    style = CVTheme.typography.captionImportance,
                    color = Gray500,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier
                        .padding(start = 12.dp, bottom = 5.dp)
                )

                Text(
                    text = requestTime,
                    style = CVTheme.typography.captionImportance,
                    color = Gray500,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier
                        .padding(start = 12.dp, bottom = 5.dp)
                )
            }

        }

        Row(
            modifier = Modifier.padding(end = 20.dp)
        ) {
            // x버튼
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_nurserequest_reject_30x30),
                contentDescription = "Reject Icon",
                modifier = Modifier.padding(end = 12.dp)
            )
            // 체크 버튼
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_nurserequest_accept_30x30),
                contentDescription = "Accept Icon",
                modifier = Modifier.padding(end = 12.dp)
            )
        }
    }
}

@Composable
fun AdminVideoListItem(
    recordedDate: String,
    videoPlayTime: String,
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = imageUrl,
            placeholder = painterResource(id = R.drawable.image_card_default),
            error = painterResource(id = R.drawable.image_card_default),
            contentDescription = "Video Icon",
            modifier = Modifier
                .height(70.dp)
                .width(90.dp)
                .padding(start = 12.dp, top = 8.dp, bottom = 8.dp)
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
                text = recordedDate,
                style = CVTheme.typography.textBody2Medium,
                color = Gray600,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
            )
            Text(
                text = videoPlayTime,
                style = CVTheme.typography.captionRegular,
                color = Gray500,
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
                    .clickable(onClick = onClick),
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
                onDeleteClick = {},
                nurseId = "간호사 번호"
            )
            AdminCameraListItem(
                cameraInfo = "입원병동 입원실 베드",
                cameraId = "123456789"
            )
            AdminRequestItem(
                nurseRequestName = "최강록",
                requestTime = "어제",
                nurseId = "간호사 번호",
            )
            AdminVideoListItem(
                recordedDate = "2024.10.08",
                videoPlayTime = "10:08",
                onClick = {}
            )
        }

    }
}
