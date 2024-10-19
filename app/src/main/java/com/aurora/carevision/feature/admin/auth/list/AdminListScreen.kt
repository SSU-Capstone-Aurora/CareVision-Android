package com.aurora.carevision.feature.admin.auth.login

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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminCameraListItem
import com.aurora.carevision.core.component.AdminHospitalListItem
import com.aurora.carevision.core.component.AdminNurseListItem
import com.aurora.carevision.core.component.AdminPatientListItem
import com.aurora.carevision.core.component.CVBasicButton
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVHeadIconSearchBar
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVTabs


@Composable
fun AdminListScreen(){
    var selectedTab by rememberSaveable {
        mutableStateOf("Nurse")
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(top = 52.dp, start = 24.dp, end = 24.dp)
    ) {
        AdminHospitalListItem(hospitalId = "정형외과", hospitalName = "서울대병원")
        CVTabs(
            tabItemTitle = listOf("간호사", "환자", "카메라"),
            onClickTabItem = { tabIndex ->
                when(tabIndex){
                    0 -> selectedTab = "Nurse"
                    1 -> selectedTab = "Patient"
                    2 -> selectedTab = "Camera"
                }
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Gray100)
        ) {
            when (selectedTab) {
                "Nurse" -> {
                    CVHeadIconSearchBar(
                        value = "",
                        onValueChange = {},
                        placeholder = "간호사 이름을 검색해주세요",
                        modifier = Modifier

                    )
                    AdminNurseListItem(
                        nurseName = "안셰프",
                        nurseId = "aurora1128",
                        modifier = Modifier
                    )
                }
                "Patient" ->{
                    CVHeadIconSearchBar(
                        value = "",
                        onValueChange = {},
                        placeholder = "환자 이름을 검색해주세요",
                        modifier = Modifier
                    )
                    AdminPatientListItem(
                        patientName = "강레오",
                        patientInfo = "2동 301호 3번 베드",
                        patientId = "7C0AA49")
                }
                "Camera" -> {
                    AdminCameraListItem(
                        cameraInfo = "2동 301호 3번 베드",
                        cameraId = "7C0AA49AAZ116FC"
                    )

                }
            }
        }
    }
}


@Composable
@Preview
fun ListScreenPreview(){

    CVTheme{
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ){
            AdminListScreen()
        }
    }
}




