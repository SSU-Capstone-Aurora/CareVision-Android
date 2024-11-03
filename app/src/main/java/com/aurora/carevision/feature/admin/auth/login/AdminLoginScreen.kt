package com.aurora.carevision.feature.admin.auth.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
fun AdminLoginScreen(
    viewModel: AdminLoginViewModel = hiltViewModel(),
    navigateToHome: () ->Unit = {},
    navigateToSignUp: () -> Unit = {},
    navigateToBack: () -> Unit = {}
) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is AdminLoginSideEffect.OnUserIdChange ->{
                    viewModel.onUserIdChange(state.userId)
                }
                is AdminLoginSideEffect.OnPasswordChange ->{
                    viewModel.onPasswordChange(state.password)
                }
                is AdminLoginSideEffect.ShowToast -> {
                    //Toast.makeText(context, sideEffect.text, Toast.LENGTH_SHORT).show()
                }
                is AdminLoginSideEffect.NavigateToHome -> navigateToHome()
                is AdminLoginSideEffect.OnSignUpClick -> navigateToSignUp()
                is AdminLoginSideEffect.OnBackClick -> navigateToBack()
                else -> {}
            }
        }
    }
//    var userID by rememberSaveable { mutableStateOf("") }
//    var password by rememberSaveable { mutableStateOf("") }
//    var isError by remember { mutableStateOf(false) }
//    var errorMessage by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .statusBarsPadding()
            .systemBarsPadding()
    ){
        TopAppBarLeft(
            onClick = {viewModel.sideEffect.value = AdminLoginSideEffect.OnBackClick},
        )
        Text(
            text = "안녕하세요 :) \n케어비전입니다",
            style = CVTheme.typography.headingPrimary,
            color = Color.Black,
            modifier = Modifier
                .padding(top=16.dp, start = 24.dp, bottom = 24.dp)
        )
        CVBasicTextField(
            value = state.userId,
            //isError = isError && userID != correctUserID,
            placeholder = "아이디를 입력해주세요",
            label = "아이디",
            onTextChanged = { viewModel.onUserIdChange(it)},
            onFocusChanged = {},
            isError = state.isLoginError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)

        )
        CVPasswordTextField(
            value = state.password,
            //isError = isError && password!= correctPassword,
            placeholder = "비밀번호를 입력해주세요",
            label = "비밀번호",
            onTextChanged = { viewModel.onPasswordChange(it) },
            onFocusChanged = {},
            isError = state.isLoginError,
            modifier = Modifier
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth()
        )
        if (state.isLoginError) {
            Text(
                text = "*아이디 또는 비밀번호가 잘못되었습니다",
                color = Red600,
                style = CVTheme.typography.captionRegular,
                modifier = Modifier
                    .padding(top = 8.dp, start = 36.dp)
                    .fillMaxWidth()
            )
        }

        CVLongButton(
            text = "로그인",
            onClick = { viewModel.onLoginClick()},
            enabled = state.userId.isNotBlank() && state.password.isNotBlank(),
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
                .clickable { viewModel.sideEffect.value = AdminLoginSideEffect.OnSignUpClick }
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


