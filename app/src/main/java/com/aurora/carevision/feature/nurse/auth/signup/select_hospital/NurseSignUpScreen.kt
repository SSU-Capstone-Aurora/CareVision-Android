package com.aurora.carevision.feature.nurse.auth.signup.select_hospital

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.ReviewDropdownMenu
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.domain.nurse.model.auth.DepartmentList
import com.aurora.carevision.domain.nurse.model.auth.HospitalList
import com.aurora.carevision.feature.nurse.auth.signup.NurseSignUpSideEffect
import com.aurora.carevision.feature.nurse.auth.signup.NurseSignUpViewModel

@Composable
fun NurseSignUpRoute(
    viewModel: NurseSignUpViewModel = hiltViewModel(),
    navigateToBack: () -> Unit = {},
    navigateToSignUpNameScreen: () -> Unit = {},
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadHospitalList()
    }

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is NurseSignUpSideEffect.NavigateToName -> {
                    navigateToSignUpNameScreen()
                }

                is NurseSignUpSideEffect.NavigateToInitialLogin -> {
                    navigateToBack()
                }

                else -> {}
            }
        }
    }

    NurseSignUpScreen(
        navigateToBack = navigateToBack,
        navigateToSignUpNameScreen = navigateToSignUpNameScreen,
        hospitalList = state.hospitalList,
        departmentList = state.departmentList,
        selectedHospitalName = state.selectedHospitalName,
        selectedDepartmentName = state.selectedDepartmentName,
        updateSelectedHospital = viewModel::updateSelectedHospital,
        updateSelectedDepartment = viewModel::updateSelectedDepartment,
        loadDepartmentList = viewModel::loadDepartmentList,
    )
}

@Composable
fun NurseSignUpScreen(
    navigateToBack: () -> Unit = {},
    navigateToSignUpNameScreen: () -> Unit = {},
    hospitalList: List<HospitalList.Hospital> = emptyList(),
    departmentList: List<DepartmentList.Department> = emptyList(),
    selectedHospitalName: String = "",
    selectedDepartmentName: String = "",
    updateSelectedHospital: (String, Int) -> Unit = { _, _ -> },
    updateSelectedDepartment: (String, Int) -> Unit = { _, _ -> },
    loadDepartmentList: (Int) -> Unit = {},
) {
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

        ReviewDropdownMenu(
            placeholder = "병원 이름을 입력하세요",
            menuItems = hospitalList.map { it.name },
            selectedItem = selectedHospitalName.ifEmpty { "병원을 선택해주세요" },
            onMenuItemClick = { selected ->
                val selectedHospital = hospitalList.find { it.name == selected }
                if (selectedHospital != null) {
                    updateSelectedHospital(selectedHospital.name, selectedHospital.id)
                    loadDepartmentList(selectedHospital.id)
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))


        ReviewDropdownMenu(
            placeholder = "과를 선택해주세요",
            menuItems = (departmentList.map { it.name }),
            selectedItem = selectedDepartmentName.ifEmpty { "과를 선택해주세요" },
            onMenuItemClick = { selected ->
                val selectedDepartment = departmentList.find { it.name == selected }
                if (selectedDepartment != null) {
                    updateSelectedDepartment(
                        selectedDepartment.name,
                        selectedDepartment.id
                    )
                }
            }
        )

        CVLongButton(
            text = "다음",
            onClick = navigateToSignUpNameScreen,
            enabled = selectedHospitalName.isNotEmpty() && selectedDepartmentName.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )
    }
}


@Composable
@Preview
fun NurseSignUpScreenPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ) {
            NurseSignUpScreen()
        }
    }
}