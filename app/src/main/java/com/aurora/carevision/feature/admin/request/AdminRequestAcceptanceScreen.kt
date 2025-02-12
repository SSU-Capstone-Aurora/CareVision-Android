package com.aurora.carevision.feature.admin.request

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.app.ui.theme.Primary400
import com.aurora.carevision.app.ui.theme.Primary600
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminRequestItem
import com.aurora.carevision.core.component.CVTopAppBar
import com.aurora.carevision.core.component.CVTwoButtonDialog
import com.aurora.carevision.domain.admin.model.nurserequest.NurseRequestList

@Composable
fun AdminRequestAcceptanceRoute(
    viewModel: AdminRequestAcceptanceViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadNurseRequests()
    }

    AdminRequestAcceptanceScreen(
        requestCount = state.requestCount,
        nurseRequestList = state.nurseRequestList,
        selectedNurseName = state.selectedNurseName ?: "",
        isDialogVisible = state.isDialogVisible,
        dismissDialog = { viewModel.dismissDialog() },
        acceptNurseRequest = {
            viewModel.acceptNurseRequest()
        },
        showDialog = { nurseId, nurseName ->
            viewModel.showDialog(nurseId, nurseName)
        }
    )
    
}

@Composable
fun AdminRequestAcceptanceScreen(
    requestCount: Int = 0,
    nurseRequestList: List<NurseRequestList.NurseRequest> = emptyList(),
    selectedNurseName: String = "",
    isDialogVisible: Boolean = false,
    dismissDialog: () -> Unit = {},
    acceptNurseRequest: () -> Unit = { },
    showDialog: (Int, String) -> Unit = { _, _ -> }
){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
        ) {
            CVTopAppBar(title = "간호사 요청")

            if (nurseRequestList.isEmpty()) {
                AdminRequestNullContent()
            } else {
                AdminRequestContent(
                    requestCount = requestCount,
                    requests = nurseRequestList,
                    onAcceptClick = {nurseId, nurseName ->
                        nurseName?.let{
                            showDialog(nurseId, nurseName)
                        }
                    },
                    onRejectClick = {
                        acceptNurseRequest() //TODO reject 구현 필요
                    }
                )
            }
        }

        if (isDialogVisible) {
            CVTwoButtonDialog(
                negativeButtonText = "취소",
                positiveButtonText = "확인",
                onNegativeButtonClicked = {
                    dismissDialog()
                },
                onPositiveButtonClicked = {
                    acceptNurseRequest()
                    dismissDialog()
                },
                title = "${selectedNurseName} 간호사의 가입 요청을\n수락하시겠습니까?",
                iconColor = Primary400,
                positiveButtonColor = Primary600
            )
        }
    }
}

@Composable
fun AdminRequestContent(
    requestCount: Int,
    requests:  List<NurseRequestList.NurseRequest>,
    onAcceptClick:(Int, String?)-> Unit,
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
                    onAcceptClick = {onAcceptClick(nurseId, nurseName) },
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
        val dummyNurseRequestList = listOf(
            NurseRequestList.NurseRequest(
                nurseId = 1,
                name = "김간호사",
                username = "김간호사",
                requestTime = "2021-09-01 12:00"
            ),
            NurseRequestList.NurseRequest(
                nurseId = 1,
                name = "김간호사",
                username = "김간호사",
                requestTime = "2021-09-01 12:00"
            ),
            NurseRequestList.NurseRequest(
                nurseId = 1,
                name = "김간호사",
                username = "김간호사",
                requestTime = "2021-09-01 12:00"
            ),
        )
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ) {
            AdminRequestAcceptanceScreen(
                nurseRequestList = dummyNurseRequestList
            )
        }
    }
}
