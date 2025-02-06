package com.aurora.carevision.feature.admin.auth.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVPasswordTextField
import com.aurora.carevision.core.component.TopAppBarLeft

@Composable
fun AdminLoginRoute(
    viewModel: AdminLoginViewModel = hiltViewModel(),
    navigateToHome: () ->Unit = {},
    navigateToSignUp: () -> Unit = {},
    navigateToBack: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is AdminLoginSideEffect.OnUserIdChange -> viewModel.onUserIdChange(state.userId)
                is AdminLoginSideEffect.OnPasswordChange -> viewModel.onPasswordChange(state.password)
                is AdminLoginSideEffect.ShowToast -> {
                    Toast.makeText(context, sideEffect.text, Toast.LENGTH_SHORT).show()
                }
                is AdminLoginSideEffect.NavigateToHome -> navigateToHome()
                is AdminLoginSideEffect.OnSignUpClick -> navigateToSignUp()
                is AdminLoginSideEffect.OnBackClick -> navigateToBack()
                is AdminLoginSideEffect.LoginSuccess ->{
                    Toast.makeText(context, "로그인 성공", Toast.LENGTH_SHORT).show()
                    navigateToHome()
                }
                else -> {}
            }
        }
    }

    AdminLoginScreen(
        navigateToBack = { navigateToBack() },
        userId = state.userId,
        password = state.password,
        onUserIdChange = { viewModel.onUserIdChange(it) },
        onPasswordChange = { viewModel.onPasswordChange(it) },
        isLoginError = state.isLoginError,
        onLoginClick = { userId, password -> viewModel.adminLogin(userId, password) },
        onSignUpClick = { navigateToSignUp() }
    )
}

@Composable
fun AdminLoginScreen(
    navigateToBack: () -> Unit = {},
    userId: String = "",
    password: String = "",
    onUserIdChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    isLoginError: Boolean = false,
    onLoginClick: (String, String) -> Unit = { _, _ -> },
    onSignUpClick: () -> Unit = {}
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ){
        TopAppBarLeft(
            onClick = { navigateToBack() },
        )
        Text(
            text = "안녕하세요 :) \n케어비전입니다",
            style = CVTheme.typography.headingPrimary,
            color = Color.Black,
            modifier = Modifier
                .padding(top=16.dp, start = 24.dp, bottom = 24.dp)
        )
        CVBasicTextField(
            value = userId,
            placeholder = "아이디를 입력해주세요",
            label = "아이디",
            onTextChanged = { onUserIdChange(it)},
            onFocusChanged = {},
            isError = isLoginError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)

        )
        CVPasswordTextField(
            value = password,
            placeholder = "비밀번호를 입력해주세요",
            label = "비밀번호",
            onTextChanged = { onPasswordChange(it) },
            onFocusChanged = {},
            isError = isLoginError,
            modifier = Modifier
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth()
        )
        if (isLoginError) {
            Text(
                text = "*아이디 또는 비밀번호가 잘못되었습니다",
                color = Red600,
                style = CVTheme.typography.captionRegular,
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 8.dp)
                    .fillMaxWidth()
            )
        }

        CVLongButton(
            text = "로그인",
            onClick = { onLoginClick(userId, password) },
            enabled = userId.isNotBlank() && password.isNotBlank(),
            modifier = Modifier
                .padding(top = 24.dp)
        )
        Text(
            textDecoration = TextDecoration.Underline,
            text = "혹시 회원이 아니신가요?",
            style = CVTheme.typography.textBody2Importance,
            color = Primary700,
            modifier = Modifier
                .padding(top = 24.dp)
                .clickable { onSignUpClick() }
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ) {
            AdminLoginScreen()
        }
    }
}


