package com.aurora.carevision.feature.admin.auth.signup.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVBasicButton
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.feature.admin.auth.signup.AdminSignUpHospitalEntrySideEffect
import com.aurora.carevision.feature.admin.auth.signup.AdminSignUpHospitalEntryViewModel

@Composable
fun AdminNameInfoScreen(
    viewModel: AdminSignUpHospitalEntryViewModel = hiltViewModel(),
    navigateToBack: () -> Unit = {},
    navigateToSignUpIdPwScreen: () -> Unit = {}
){
    val state = viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is AdminSignUpHospitalEntrySideEffect.NavigateToIdPw -> {
                    navigateToSignUpIdPwScreen()
                }
                is AdminSignUpHospitalEntrySideEffect.NavigateToInitialLogin -> {
                    navigateToBack()
                }
                else -> {
                }
            }
        }
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .systemBarsPadding()
            .statusBarsPadding()
    ){
        TopAppBarLeft(
            onClick = navigateToBack
        )

        Text(
            text = "가입을 위한 정보를\n입력해주세요",
            style = CVTheme.typography.headingPrimary,
            color = Black,
            modifier = Modifier
                .padding(top=16.dp, start = 24.dp, end = 24.dp , bottom = 24.dp)
        )
        CVBasicTextField(
            value = state.value.userName,
            placeholder = "이름을 입력해주세요",
            label = "이름",
            onTextChanged = { viewModel.updateUserName(it) },
            onFocusChanged = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)

        )

        CVBasicButton(
            text = "다음",
            onClick = navigateToSignUpIdPwScreen,
            enabled = state.value.userName.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp, end = 24.dp),
        )
    }
}

@Composable
@Preview
fun AdminHospitalCreationScreenPreview(){
    val correctUserID = "admin"
    val correctPassword = "password"
    CVTheme{
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ){
            AdminNameInfoScreen()
        }
    }
}
