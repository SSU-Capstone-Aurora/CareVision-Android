package com.aurora.carevision.feature.nurse.patient.registration.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminPatientListItem
import com.aurora.carevision.core.component.CVHeadIconSearchBar
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.domain.nurse.model.Patient

@Composable
fun PatientRegistrationScreen(
    onClickNavigateToSelfRegistration: () -> Unit = {},
    onClickNavigateToRegistrationDone: () -> Unit = {},
    onClickNavigateToBack: () -> Unit = {}
) {
    var selectedPatientId by remember { mutableStateOf<Int?>(null) }

    val dummyList = listOf(
        Patient(
            patientId = 1,
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01"
        ),
        Patient(
            patientId = 2,
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01"
        ),
        Patient(
            patientId = 3,
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01"
        ),
        Patient(
            patientId = 4,
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01"
        ),
        Patient(
            patientId = 5,
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01"
        ),
        Patient(
            patientId = 6,
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01"
        ),
        Patient(
            patientId = 7,
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01"
        ),
        Patient(
            patientId = 8,
            patientName = "오로라",
            patientNum = "07-FJw144",
            patientRoom = "2동 101호 4번 베드",
            registrationDate = "2021.10.01"
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
    ) {
        TopAppBarLeft("환자 등록", onClick = onClickNavigateToBack)

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 26.dp, start = 24.dp, end = 24.dp)
        ) {
            Text(
                text = "연결할 환자를 선택해주세요",
                color = Gray700,
                style = CVTheme.typography.headingSecondary,
                modifier = Modifier
            )

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(35.dp)
                    .background(White)
                    .border(1.dp, Gray300, shape = RoundedCornerShape(10.dp))
                    .clickable { onClickNavigateToSelfRegistration() },

                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "add patient",
                    tint = Gray500
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        var text by remember { mutableStateOf("") } // TODO Move To viewModel

        CVHeadIconSearchBar(
            value = text,
            onValueChange = { newValue -> text = newValue },
            placeholder = "환자 이름으로 검색"
        )

        LazyColumn(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            items(dummyList) { patient ->
                AdminPatientListItem(
                    patientId = patient.patientNum,
                    patientName = patient.patientName,
                    patientInfo = patient.patientRoom,
                    isSelected = selectedPatientId == patient.patientId,
                    onClick = {
                        selectedPatientId =
                            if (selectedPatientId == patient.patientId) null else patient.patientId
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                CVLongButton(
                    text = "다음",
                    onClick = { onClickNavigateToRegistrationDone() },
                    enabled = selectedPatientId != null
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewPatientRegistrationScreen() {
    CVTheme {
        PatientRegistrationScreen()
    }
}