package com.aurora.carevision.feature.admin.auth.request

import android.service.controls.Control
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray200
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminCameraListItem
import com.aurora.carevision.core.component.AdminHospitalListItem
import com.aurora.carevision.core.component.AdminNurseListItem
import com.aurora.carevision.core.component.AdminPatientListItem
import com.aurora.carevision.core.component.AdminRequestItem
import com.aurora.carevision.core.component.CVBasicButton
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVHeadIconSearchBar
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVTabs
import com.aurora.carevision.core.component.CVTopAppBar


@Composable
fun AdminRequestScreen(){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(top = 52.dp)
    ) {
        CVTopAppBar(title = "간호사 요청")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Gray100)
        ) {
            Text(
                text = "3개의 요청이 있어요",
                style = CVTheme.typography.headingPrimary,
                color = Gray700,
                modifier = Modifier
                    .padding(top =36.dp, start= 24.dp )
            )
            AdminRequestItem(
                nurseRequestName = "안셰프",
                nurseId = "aurora1128",
                requestTime = "5분 전"
            )
            AdminRequestItem(
                nurseRequestName = "최강록",
                nurseId = "aurora1128",
                requestTime = "10분 전"
            )
            AdminRequestItem(
                nurseRequestName = "최강록",
                nurseId = "aurora1128",
                requestTime = "어제"
            )
        }
    }
}


@Composable
@Preview
fun AdminRequestPreview(){

    CVTheme{
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ){
            AdminRequestScreen()
        }
    }
}




