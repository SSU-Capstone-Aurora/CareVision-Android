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
import com.aurora.carevision.core.component.AdminNurseListItem
import com.aurora.carevision.core.component.CVHeadIconSearchBar

@Composable
fun NurseListScreen() {
    val dummyNurseList = listOf("안셰프" to "aurora1128")

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
        items(dummyNurseList) { (name, id) ->
            AdminNurseListItem(
                nurseName = name,
                nurseId = id,
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