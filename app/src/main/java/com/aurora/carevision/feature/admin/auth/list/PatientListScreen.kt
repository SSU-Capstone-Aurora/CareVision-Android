package com.aurora.carevision.feature.admin.auth.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.core.component.AdminPatientListItem
import com.aurora.carevision.core.component.CVHeadIconSearchBar

@Composable
fun PatientListScreen() {
    val dummyPatientList = listOf("강레오" to "2동 301호 3번 베드")

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
        items(dummyPatientList) { (name, info) ->
            AdminPatientListItem(
                patientName = name,
                patientInfo = info,
                patientId = "7C0AA49",
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