package com.aurora.carevision.feature.admin.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminHospitalListItem
import com.aurora.carevision.core.component.CVTabs
import com.aurora.carevision.feature.admin.home.cameralist.CameraListRoute
import com.aurora.carevision.feature.admin.home.nurselist.NurseListRoute
import com.aurora.carevision.feature.admin.home.patientlist.PatientListRoute

// TOOD : Screen to Route
@Composable
fun AdminListScreen() {
    var selectedTab by rememberSaveable { mutableStateOf("Nurse") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
    ) {
        Column(
            modifier = Modifier
                .background(White)
        ) {
            AdminHospitalListItem(hospitalDepartment = "국제성모병원", hospitalName = "정신건강의학과") //TODO 관리자 정보 입력해야함
            CVTabs(
                tabItemTitle = listOf("간호사", "환자", "카메라"),
                onClickTabItem = { tabIndex ->
                    when (tabIndex) {
                        0 -> selectedTab = "Nurse"
                        1 -> selectedTab = "Patient"
                        2 -> selectedTab = "Camera"
                    }
                }
            )
        }

        Column(
            modifier = Modifier
                .background(Color.Transparent)
                .padding(top = 168.dp, start = 24.dp, end = 24.dp)
        ) {
            when (selectedTab) {
                "Nurse" -> NurseListRoute()
                "Patient" -> PatientListRoute()
                "Camera" -> CameraListRoute()
            }
        }
    }
}

@Composable
@Preview
fun AdminListScreenPreview() {
    CVTheme {
        AdminListScreen()
    }
}
