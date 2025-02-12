package com.aurora.carevision.feature.admin.home.patientlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminPatientListItem
import com.aurora.carevision.core.component.CVHeadIconSearchBar
import com.aurora.carevision.domain.admin.model.patient.Patient

@Composable
fun PatientListRoute(
    viewModel: PatientListViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    LaunchedEffect(key1 = Unit) {
        viewModel.getAdminPatientList()
    }

    PatientListScreen(
        patientList = state.patientList
    )

}

@Composable
fun PatientListScreen(
    patientList: List<Patient> = emptyList()
){
    Spacer(modifier = Modifier.height(8.dp))
    CVHeadIconSearchBar(
        value = "",
        onValueChange = {},
        placeholder = "환자 이름을 검색해주세요",
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(15.dp))

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp)
    ) {
        items(patientList) { patient ->
            AdminPatientListItem(
                patientName = patient.patientName,
                patientInfo = "${patient.inpatientWardNumber}동 ${patient.patientRoom}호 ${patient.bedNumber}번 베드",
                patientId = patient.code,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
@Preview
fun PatientListScreenPreview(){

    CVTheme{
        val dummyPatientList = listOf(
            Patient(
                code = "1",
                patientName = "김철수",
                inpatientWardNumber = 1,
                patientRoom = 121,
                bedNumber = 1
            ),

            Patient(
                code = "1",
                patientName = "김철수",
                inpatientWardNumber = 1,
                patientRoom = 121,
                bedNumber = 1
            ),

            Patient(
                code = "1",
                patientName = "김철수",
                inpatientWardNumber = 1,
                patientRoom = 121,
                bedNumber = 1
            ),
            Patient(
                code = "1",
                patientName = "김철수",
                inpatientWardNumber = 1,
                patientRoom = 121,
                bedNumber = 1
            ),
            Patient(
                code = "1",
                patientName = "김철수",
                inpatientWardNumber = 1,
                patientRoom = 121,
                bedNumber = 1
            ),
        )

        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ){
            PatientListScreen(
                patientList = dummyPatientList
            )
        }
    }
}