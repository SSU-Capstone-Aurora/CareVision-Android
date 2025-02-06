package com.aurora.carevision.feature.admin.home.nurselist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminNurseListItem
import com.aurora.carevision.core.component.CVHeadIconSearchBar
import com.aurora.carevision.domain.admin.model.nurse.NurseInfo

@Composable
fun NurseListRoute(
    viewModel: NurseListScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    LaunchedEffect(key1 = Unit) {
        viewModel.loadNurseList()
    }

    NurseListScreen(
        nurseList = state.nurseList
    )
}

@Composable
fun NurseListScreen(
    nurseList: List<NurseInfo> = emptyList()
) {
    Spacer(modifier = Modifier.height(8.dp))
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
        items(nurseList) { nurse ->
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
fun NurseListScreenPreview() {

    CVTheme {
        val dummyNurseList = listOf(
            NurseInfo("1", "김간호사"),
            NurseInfo("2", "박간호사"),
            NurseInfo("3", "이간호사"),
            NurseInfo("4", "최간호사"),
            NurseInfo("5", "정간호사"),
            NurseInfo("6", "홍간호사"),
            NurseInfo("7", "윤간호사"),
            NurseInfo("8", "장간호사"),
            NurseInfo("9", "임간호사"),
            NurseInfo("10", "오간호사"),
        )

        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ) {
            NurseListScreen(
                nurseList = dummyNurseList
            )
        }
    }
}