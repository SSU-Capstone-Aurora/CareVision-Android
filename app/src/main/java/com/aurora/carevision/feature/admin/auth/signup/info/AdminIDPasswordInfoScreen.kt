package com.aurora.carevision.feature.admin.auth.signup.info

import android.widget.Toast
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVDuplicateCheckTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVSignInPasswordTextField
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.feature.admin.auth.signup.AdminSignUpHospitalEntrySideEffect
import com.aurora.carevision.feature.admin.auth.signup.AdminSignUpHospitalEntryViewModel

@Composable
fun AdminIDPasswordInfoRoute(
    viewModel: AdminSignUpHospitalEntryViewModel = hiltViewModel(),
    navigateToAdminLogin:() ->Unit = {},
    navigateToBack:() -> Unit = {},
){

    val state = viewModel.state.collectAsStateWithLifecycle().value
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is AdminSignUpHospitalEntrySideEffect.NavigateToInitialLogin -> {
                    navigateToBack()
                }

                is AdminSignUpHospitalEntrySideEffect.ShowToast -> {
                    Toast.makeText(
                        context,
                        sideEffect.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is AdminSignUpHospitalEntrySideEffect.SignUpSuccess -> {
                    navigateToAdminLogin()
                    Toast.makeText(
                        context,
                        "회원가입이 완료되었습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {}
            }
        }
    }

    AdminIDPasswordInfoScreen(
        navigateToBack = navigateToBack,
        userId = state.userId,
        password = state.password,
        updateUserId = {viewModel.updateUserId(it)},
        updateDoCheckNameDuplicate = {viewModel.updateDoCheckNameDuplicate(it)},
        updatePassword = {viewModel.updatePassword(it)},
        checkIdValidation = {viewModel.checkIdValidation()},
        checkPwValidation = {viewModel.checkPwValidation()},
        nameDuplicate = state.nameDuplicate,
        requestSignUp = {viewModel.requestSignUp()}
    )
}

@Composable
fun AdminIDPasswordInfoScreen(
    navigateToBack: () -> Unit = {},
    userId: String = "",
    password: String = "",
    updateUserId: (String) -> Unit = {},
    updateDoCheckNameDuplicate: (Boolean) -> Unit = {},
    updatePassword: (String) -> Unit = {},
    checkIdValidation: () -> Unit = {},
    checkPwValidation: () -> Boolean = { false },
    nameDuplicate: Boolean = false,
    requestSignUp: () -> Unit = {},
){
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
                .padding(top=16.dp, start = 24.dp, end = 24.dp, bottom = 24.dp)
        )
        CVDuplicateCheckTextField(
            value = userId,
            placeholder = "아이디를 입력해주세요",
            label = "아이디",
            onTextChanged = {
                updateUserId(it)
                updateDoCheckNameDuplicate(false)
            },
            onFocusChanged = {},
            onDuplicateCheck = {checkIdValidation()},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
        )
        if (!nameDuplicate) {
            Text(
                text = "* 아이디가 중복됩니다.",
                color = Red600,
                style = CVTheme.typography.captionRegular,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
        }
        Spacer(modifier = Modifier.padding())
        CVSignInPasswordTextField(
            value = password,
            isError = false,
            placeholder = "비밀번호를 입력해주세요",
            label = "비밀번호",
            onTextChanged = {updatePassword(it)},
            onFocusChanged = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
        )
        if ((password.isNotEmpty() && password.length < 8)) {
            Text(
                text = "* 8글자 이상이어야 합니다",
                color = Red600,
                style = CVTheme.typography.captionRegular,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 24.dp)
            )
        }

        if (!checkPwValidation()) {
            Text(
                text = "* 영문과 숫자가 포함되어야 합니다",
                color = Red600,
                style = CVTheme.typography.captionRegular,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
        }


        CVLongButton(
            text = "완료",
            onClick = {
                //navigateToSignUpWaitingScreen()
                requestSignUp()
            },
            enabled = (userId.isNotEmpty() && password.isNotEmpty() && password.length >= 8 && checkPwValidation() && nameDuplicate && nameDuplicate),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )
    }
}


@Composable
@Preview
fun AdminIDPasswordInfoScreenPreview(){
    CVTheme{
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ){
            AdminIDPasswordInfoScreen()
        }
    }
}

