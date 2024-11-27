package com.aurora.carevision.feature.admin.request

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminRequestItem
import com.aurora.carevision.core.component.CVTopAppBar
import com.aurora.carevision.domain.admin.model.nurserequest.NurseRequestList

@Composable
fun AdminRequestAcceptanceScreen(
    viewModel: AdminRequestAcceptanceViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    //val requests = remember { listOf("안셰프" to "5분 전") }
    LaunchedEffect(Unit) {
        viewModel.loadNurseRequests()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
        ) {
            CVTopAppBar(title = "간호사 요청")

            if (state.requests.isEmpty()) {
                AdminRequestNullContent()
            } else {
                AdminRequestContent(
                    requestCount = state.requestCount,
                    requests = state.requests,
                    onAcceptClick = {nurseId ->
                        viewModel.acceptNurseRequest(nurseId)
                    },
                    onRejectClick = {nurseId ->
                        viewModel.acceptNurseRequest(nurseId) //TODO reject 구현 필요
                    }
                )
            }
        }
    }
}

@Composable
fun AdminRequestContent(
    requestCount: Int,
    requests:  List<NurseRequestList.NurseRequest>,
    onAcceptClick:(Int)-> Unit,
    onRejectClick:(Int)-> Unit,
) {
    Column(
        modifier = Modifier
            .background(Gray100)
            .fillMaxSize()
    ) {
        Text(
            text = "$requestCount 개의 요청이 있어요",
            style = CVTheme.typography.headingPrimary,
            color = Gray700,
            modifier = Modifier.padding(top = 36.dp, start = 24.dp)
        )

        LazyColumn(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp)
        ) {
            items(requests.size) { index ->
                val (nurseId, nurseName, userName, requestTime) = requests[index]
                AdminRequestItem(
                    nurseRequestName = nurseName,
                    nurseId = userName,
                    requestTime = requestTime,
                    onAcceptClick = {onAcceptClick(nurseId) },
                    onRejectClick = {onRejectClick(nurseId)},
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun AdminRequestNullContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(start = 24.dp, end = 24.dp, bottom = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_has_no_alarm),
            contentDescription = "No Alarm Image",
            modifier = Modifier.size(width = 341.dp, height = 267.dp)
        )
        Text(
            text = "알림이 없습니다",
            style = CVTheme.typography.headingSecondary,
            color = Color.Black,
            modifier = Modifier.padding(top = 36.dp)
        )
    }
}

@Composable
@Preview
fun AdminRequestPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ) {
            AdminRequestAcceptanceScreen()
        }
    }
}
