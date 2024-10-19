package com.aurora.carevision.feature.nurse.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray600
import com.aurora.carevision.app.ui.theme.Primary100
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.domain.nurse.notification.Notification

@Composable
fun NotificationScreen() {

    Column(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
    ) {
        TopAppBarLeft(title = stringResource(R.string.tv_notification))

        val hasAlarm = true
        val notifications = listOf(
            Notification("101호 1번 침대", "3분전", "환자가 침대에서 일어났습니다.", true),
            Notification("102호 2번 침대", "5분전", "환자가 도움을 요청했습니다.", false),
            Notification("101호 1번 침대", "3분전", "환자가 침대에서 일어났습니다.", true),
            Notification("102호 2번 침대", "5분전", "환자가 도움을 요청했습니다.", false),
        )

        if(hasAlarm) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(notifications) { notification ->
                    NotificationList(
                        roomBedInfo = notification.roomBedInfo,
                        notificationTime = notification.notificationTime,
                        notificationContent = notification.notificationContent,
                        isChecked = notification.isChecked
                    )
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.img_has_no_alarm), contentDescription = "no alarm image")

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = stringResource(R.string.tv_has_no_alarm),
                    style = CVTheme.typography.textBody1Importance,
                    color = Gray600,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun NotificationList(
    modifier : Modifier = Modifier,
    roomBedInfo: String = "",
    notificationTime: String = "",
    notificationContent: String = "",
    isChecked: Boolean = false
) {
    Row(
        modifier = Modifier
            .background(if (isChecked) White else Primary100)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier = Modifier.padding(vertical = 20.dp, horizontal = 24.dp)
        ) {
            Text(text = roomBedInfo, style = CVTheme.typography.captionRegular, color = Gray500)
            Text(text = notificationContent, style = CVTheme.typography.textBody2Importance, color = Gray600)
        }

        Text(text = notificationTime, style = CVTheme.typography.captionImportance, color = Gray500, modifier = Modifier.padding(end = 24.dp, top = 20.dp))
    }
}

@Composable
@Preview
fun NotificationScreenPreview() {
    CVTheme {
        NotificationScreen()
    }
}