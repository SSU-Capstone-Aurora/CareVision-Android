package com.aurora.carevision.feature.nurse.patient.registration.search

import android.util.Log
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.app.ui.theme.Primary500
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminPatientListItem
import com.aurora.carevision.core.component.CVHeadIconSearchBar
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.domain.nurse.model.Patient

// TODO : refact screen to route

@Composable
fun PatientRegistrationScreen(
    onClickNavigateToSelfRegistration: () -> Unit = {},
    onClickNavigateToRegistrationDone: () -> Unit = {},
    onClickNavigateToBack: () -> Unit = {},
    viewModel: PatientRegistrationViewModel = hiltViewModel(),
) {
    var selectedPatientId by remember { mutableStateOf<Int?>(null) }
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(key1 = Unit) {
        viewModel.getPatientList()
    }

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
                    .wrapContentSize()
                    .background(Primary500)
                    .padding(8.dp)
                    .clickable { onClickNavigateToSelfRegistration() },

                contentAlignment = Alignment.Center
            ) {
                Text(text = "직접 등록", color = White, style = CVTheme.typography.captionImportance)
            }
        }

        //Spacer(modifier = Modifier.height(16.dp))
        //var text by remember { mutableStateOf("") } // TODO Move To viewModel

        //CVHeadIconSearchBar(
        //    value = text,
        //    onValueChange = { newValue -> text = newValue },
        //    placeholder = "환자 이름으로 검색"
        //)

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .weight(1f)
        ) {
            items(state.patientList) { patient ->
                AdminPatientListItem(
                    patientId = patient.patientCode,
                    patientName = patient.patientName,
                    patientInfo = "${patient.inpatientWardNumber}동 ${patient.patientRoom}호 ${patient.bedNumber}번 침대",
                    isSelected = selectedPatientId == patient.patientId,
                    onClick = {
                        selectedPatientId =
                            if (selectedPatientId == patient.patientId) null else patient.patientId
                        viewModel.updateSelectedPatient(patient)
                        Log.d("PatientRegistrationScreen", "selectedPatientId: ${state.selectedPatient?.patientId}")
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        CVLongButton(
            text = "다음",
            onClick = { onClickNavigateToRegistrationDone() },
            enabled = selectedPatientId != null,
            modifier = Modifier.padding(bottom = 15.dp)
        )
    }
}

@Composable
@Preview
fun PreviewPatientRegistrationScreen() {
    CVTheme {
        PatientRegistrationScreen()
    }
}