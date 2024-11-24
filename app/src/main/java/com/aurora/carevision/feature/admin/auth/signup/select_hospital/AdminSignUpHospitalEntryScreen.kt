package com.aurora.carevision.feature.admin.auth.signup.select_hospital

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVTailIconSearchBar
import com.aurora.carevision.core.component.ReviewDropdownMenu
import com.aurora.carevision.core.component.SearchBarDropdownMenu
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.feature.admin.auth.signup.AdminSignUpHospitalEntrySideEffect
import com.aurora.carevision.feature.admin.auth.signup.AdminSignUpHospitalEntryViewModel

@Composable
fun AdminSignUpHospitalEntryScreen(
    viewModel: AdminSignUpHospitalEntryViewModel = hiltViewModel(),
    navigateToSignUpNameScreen: () -> Unit = {},
    navigateToBack:() -> Unit = {},
) {

    val state by viewModel.state.collectAsState()
    val context = LocalContext.current
    var showDropdown by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.performHospitalSearch(state.searchQuery)
    }

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is AdminSignUpHospitalEntrySideEffect.NavigateToName ->
                    navigateToSignUpNameScreen()

                is AdminSignUpHospitalEntrySideEffect.NavigateToInitialLogin -> {
                    navigateToBack()
                }

                else -> {}
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .statusBarsPadding()
            .systemBarsPadding()
    ) {
        TopAppBarLeft(
            onClick = navigateToBack,
        )
        Text(
            text = "환영합니다!\n어디에서 근무 중이신가요?",
            style = CVTheme.typography.headingPrimary,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 16.dp, start = 24.dp, end = 24.dp, bottom = 24.dp)
        )

        SearchBarDropdownMenu(
            value = if(state.departmentList.isNotEmpty()) state.selectedHospitalName else state.searchQuery,
            onValueChange = { query ->
                viewModel.updateSearchQuery(query)
            },
            menuItems = state.hospitalList.map { it.name },
            onMenuItemClick = { selected ->
                val selectedHospital = state.hospitalList.find { it.name == selected }
                if (selectedHospital != null) {
                    viewModel.updateSelectedHospital(selectedHospital.name, selectedHospital.ykiho)
                    viewModel.loadDepartmentList(selectedHospital.ykiho)

                }
            },
            onSearchClick = {
                if (state.searchQuery.isNotEmpty()) {
                    viewModel.performHospitalSearch(state.searchQuery)
                    showDropdown = true
                }
            },
            onFocusChanged = {},
            onTextChanged = {}
        )
//        if (state.hospitalList.isNotEmpty()) {
//            ReviewDropdownMenu(
//                menuItems = state.hospitalList.map { it.name },
//                selectedItem = state.selectedHospitalName.ifEmpty { "병원을 선택해주세요" },
//                placeholder = "병원을 선택해주세요",
//                onMenuItemClick = { selected ->
//                    val selectedHospital = state.hospitalList.find { it.name == selected }
//                    if (selectedHospital != null) {
//                        viewModel.updateSelectedHospital(selectedHospital.name, selectedHospital.id)
//                        viewModel.loadDepartmentList(selectedHospital.id)
//                        showDropdown = false
//                    }
//                }
//            )
//        }


        Spacer(modifier = Modifier.height(24.dp))
        if(state.isHospitalSelected && state.departmentList.isNotEmpty()) {
            ReviewDropdownMenu(
                placeholder = "과를 선택해주세요",
                menuItems = (state.departmentList),
                selectedItem = state.selectedDepartmentName.ifEmpty { "과를 선택해주세요" },
                onMenuItemClick = { selected ->
                    val selectedDepartment = state.departmentList.find { it == selected }
                    if (selectedDepartment != null) {
                        viewModel.updateSelectedDepartment(
                            selectedDepartment
                        )
                    }
                }
            )
        }
        CVLongButton(
            text = "다음",
            onClick = navigateToSignUpNameScreen,
            //enabled = state.selectedHospitalName.isNotEmpty() && state.selectedDepartmentName.isNotEmpty(),
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )
    }
}
@Composable
@Preview
fun AdminSignUpScreenPreview(){
    CVTheme{
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ){
            AdminSignUpHospitalEntryScreen()
        }
    }
}

