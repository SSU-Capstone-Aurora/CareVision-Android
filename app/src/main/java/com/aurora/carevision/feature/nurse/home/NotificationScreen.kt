package com.aurora.carevision.feature.nurse.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray600
import com.aurora.carevision.app.ui.theme.Primary100
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.domain.nurse.model.notification.Notification
import com.aurora.carevision.feature.nurse.home.home.HomeViewModel

@Composable
fun NotificationRoute(
    onBackClick: () -> Unit = {},
    navigateToSpecificPatientStreaming: () -> Unit = {},
    viewModel: HomeViewModel = hiltViewModel()
) {

    val state = viewModel.state.collectAsStateWithLifecycle().value

    NotificationScreen(
        onBackClick = onBackClick,
        navigateToSpecificPatientStreaming = navigateToSpecificPatientStreaming,
        updateClickedPatientId = { viewModel.updateClickedPatientId(it) },
        notificationList = state.notificationList
    )

}

@Composable
fun NotificationScreen(
    onBackClick: () -> Unit = {},
    navigateToSpecificPatientStreaming: () -> Unit = {},
    updateClickedPatientId: (Int) -> Unit = {},
    notificationList: List<Notification> = emptyList()
){
    Column(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
    ) {
        TopAppBarLeft(title = stringResource(R.string.tv_notification), onClick = onBackClick)

        if(notificationList.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(notificationList) { notification ->
                    NotificationList(
                        patientName = notification.patientName,
                        notificationTime = notification.notificationTime,
                        inPatientWardNumber = notification.inpatientWardNumber,
                        patientRoomNumber = notification.patientRoomNumber,
                        bedNumber = notification.bedNumber,
                        isChecked = notification.isChecked,
                        navigateToSpecificPatientStreaming = navigateToSpecificPatientStreaming,
                        onClickItem = {
                            updateClickedPatientId(notification.patientId)
                        }
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
    onClickItem: () -> Unit,
    modifier : Modifier = Modifier,
    patientName: String = "",
    inPatientWardNumber: Int = 0,
    patientRoomNumber: Int = 0,
    bedNumber: Int = 0,
    notificationTime: String = "",
    isChecked: Boolean = false,
    navigateToSpecificPatientStreaming: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .background(if (isChecked) White else Primary100)
            .fillMaxWidth()
            .clickable {
                navigateToSpecificPatientStreaming()
                onClickItem()
                       },
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier = modifier.padding(vertical = 20.dp, horizontal = 24.dp)
        ) {
            Text(text = "${inPatientWardNumber}동 ${patientRoomNumber}호 ${bedNumber}베드", style = CVTheme.typography.captionRegular, color = Gray500)
            Text(text = "$patientName 님의 이상행동이 감지되었습니다.", style = CVTheme.typography.textBody2Importance, color = Gray600)
        }

        Text(text = notificationTime, style = CVTheme.typography.captionImportance, color = Gray500, modifier = modifier.padding(end = 24.dp, top = 20.dp))
    }
}

@Composable
@Preview
fun NotificationScreenEmyptyPreview() {
    CVTheme {
        NotificationScreen()
    }
}

@Composable
@Preview
fun NotificationScreenPreview() {
    CVTheme {
        val notificationList = listOf(
            Notification("1", 1, "1", 101, 1, 212, "2021-09-01 12:00:00", false),
            Notification("2", 2, "2", 102, 2, 213, "2021-09-01 12:00:00", true),
            Notification("3", 3, "3", 103, 3, 214, "2021-09-01 12:00:00", false),
            Notification("4", 4, "4", 104, 4, 215, "2021-09-01 12:00:00", true),
        )
        NotificationScreen(notificationList = notificationList)
    }
}