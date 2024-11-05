package com.aurora.carevision.feature.nurse.auth.signup.info

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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVDuplicateCheckTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVSignInPasswordTextField
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.feature.nurse.auth.signup.NurseSignUpViewModel

@Composable
fun NurseSignUpIdPwScreen(
    viewModel: NurseSignUpViewModel = hiltViewModel(),
    navigateToBack: () -> Unit = {},
    navigateToSignUpWaitingScreen: () -> Unit = {}
) {

    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .systemBarsPadding()
            .statusBarsPadding()
    ) {
        TopAppBarLeft(
            onClick = navigateToBack
        )
        Text(
            text = "가입을 위한 정보를\n입력해주세요",
            style = CVTheme.typography.headingPrimary,
            color = Black,
            modifier = Modifier
                .padding(top = 16.dp, start = 24.dp, end = 24.dp, bottom = 24.dp)
        )
        CVDuplicateCheckTextField(
            value = state.value.userId,
            placeholder = "아이디를 입력해주세요",
            label = "아이디",
            onTextChanged = { viewModel.updateUserId(it) },
            onFocusChanged = { },
            onDuplicateCheck = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 4.dp)
        )
        if (!viewModel.checkIdValidation()) {
            Text(
                text = "* 아이디가 중복됩니다.",
                color = Red600,
                style = CVTheme.typography.captionRegular,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        CVSignInPasswordTextField(
            value = state.value.password,
            isError = false,
            placeholder = "비밀번호를 입력해주세요",
            label = "비밀번호",
            onTextChanged = { viewModel.updatePassword(it) },
            onFocusChanged = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
        )

        if ((state.value.password.isNotEmpty() && state.value.password.length < 8)) {
            Text(
                text = "* 8글자 이상이어야 합니다",
                color = Red600,
                style = CVTheme.typography.captionRegular,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 24.dp)
            )
        }

        if (!viewModel.checkPwValidation()) {
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
            onClick = navigateToSignUpWaitingScreen,
            enabled = (state.value.userId.isNotEmpty() && state.value.password.isNotEmpty() && state.value.password.length >= 8 && viewModel.checkPwValidation() && !viewModel.checkIdValidation()),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )
    }
}

@Composable
@Preview
fun NurseSignUpIdPwScreenPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ) {
            NurseSignUpIdPwScreen()
        }
    }
}