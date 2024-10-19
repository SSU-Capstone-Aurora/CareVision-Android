package com.aurora.carevision.feature.nurse.patient.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray200
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray600
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVDropdownMenu
import com.aurora.carevision.domain.nurse.Patient

@Composable
fun PatientInfoScreen(){

    val userName = "오로라"
    val dummyList = listOf(
        Patient(
            patientId = 1,
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01"
        ),
        Patient(
            patientId = 1,
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01"
        ),
        Patient(
            patientId = 1,
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01"
        ),
        Patient(
            patientId = 1,
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01"
        ),
        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100),
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = userName,
            color = Gray500,
            style = CVTheme.typography.textBody2Importance,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 4.dp)
        )
        Text(text = stringResource(R.string.tv_my_patient_list),
            color = Gray600,
            style = CVTheme.typography.headingSecondary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
        ) {
            items(dummyList) { patient ->
                MyPatientListItem(
                    patientName = patient.patientName,
                    patientNum = patient.patientNum,
                    patientRoom = patient.patientRoom,
                    registrationDate = patient.registrationDate,
                    onClick = {},
                )
            }
        }

    }
}

@Composable
fun MyPatientListItem(
    patientName: String,
    patientNum: String,
    patientRoom: String,
    registrationDate: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .background(White)
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(painter = painterResource(id = R.drawable.ic_video_default), contentDescription = "default", modifier = Modifier.padding(16.dp))
            Column(
                modifier = Modifier.weight(2f)
            ) {
                Row(
                    modifier = Modifier.padding(top = 12.dp, bottom = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = patientName,
                        color = Gray600,
                        style = CVTheme.typography.textBody1Importance,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = patientNum,
                        color = Primary700,
                        style = CVTheme.typography.captionImportance,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
                Text(
                    text = patientRoom,
                    color = Gray500,
                    style = CVTheme.typography.textBody2Medium,
                )

                Box(
                    modifier = Modifier
                        .height(2.dp)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .background(Gray100)
                )
            }
            CVDropdownMenu(
                menuItems = listOf("퇴원"),
                onMenuItemClick = { selectedItem ->
                    println("Selected item: $selectedItem")
                }
            )
        }
        Spacer(modifier = Modifier.height(1.dp).fillMaxWidth().background(Gray100))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "등록일",
                color = Gray600,
                style = CVTheme.typography.captionImportance,
            )
            Text(
                text = registrationDate,
                color = Gray500,
                style = CVTheme.typography.captionImportance,
            )
        }

    }
}

@Composable
@Preview
fun PatientInfoScreenPreview(){
    CVTheme {
        PatientInfoScreen()
    }
}

@Composable
@Preview
fun MyPatientListItemPreview(){
    CVTheme {
        MyPatientListItem(
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01",
            onClick = {}
        )
    }
}