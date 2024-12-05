package com.aurora.carevision.feature.admin.home.nurselist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.core.component.AdminNurseListItem
import com.aurora.carevision.core.component.CVHeadIconSearchBar

@Composable
fun NurseListScreen(
    viewModel: NurseListScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    //val nurseList by viewModel.adminNurseListState.collectAsState()
    //val dummyNurseList = listOf("안셰프" to "aurora1128")

    LaunchedEffect(key1 = Unit) {
        viewModel.loadNurseList()
    }

    CVHeadIconSearchBar(
        value = "",
        onValueChange = {},
        placeholder = "간호사 이름을 검색해주세요",
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(8.dp))

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(state.nurses) { nurse ->
            AdminNurseListItem(
                nurseName = nurse.name,
                nurseId = nurse.id,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
@Preview
fun NurseListScreenPreview(){

    CVTheme{
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ){
            NurseListScreen()
        }
    }
}