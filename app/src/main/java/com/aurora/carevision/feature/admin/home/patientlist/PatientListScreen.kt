package com.aurora.carevision.feature.admin.home.patientlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.core.component.AdminPatientListItem
import com.aurora.carevision.core.component.CVHeadIconSearchBar

@Composable
fun PatientListScreen(
    viewModel: PatientListViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    val context = LocalContext.current
    //val dummyPatientList = listOf("강레오" to "2동 301호 3번 베드")

    LaunchedEffect(key1 = Unit) {
        viewModel.getAdminPatientList()
    }

    CVHeadIconSearchBar(
        value = "",
        onValueChange = {},
        placeholder = "환자 이름을 검색해주세요",
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(8.dp))

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(state.patientList) { patient ->
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
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ){
            PatientListScreen()
        }
    }
}