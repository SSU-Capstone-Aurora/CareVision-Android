package com.aurora.carevision.feature.nurse.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVPasswordTextField
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.feature.admin.auth.login.AdminLoginScreen

@Composable
fun NurseLoginScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ){

        TopAppBarLeft()

        Text(
            text = "안녕하세요 :) \n케어비전입니다",
            style = CVTheme.typography.headingPrimary,
            color = Color.Black,
            modifier = Modifier
                .padding(top=16.dp, start = 24.dp, bottom = 24.dp)
        )
        CVBasicTextField(
            value = "",
            placeholder = "아이디를 입력해주세요",
            label = "아이디",
            onTextChanged = { },
            onFocusChanged = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)

        )
        CVPasswordTextField(
            value = "",
            //isError = ,
            placeholder = "비밀번호를 입력해주세요",
            label = "비밀번호",
            onTextChanged = { },
            onFocusChanged = {},
            modifier = Modifier
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth()
        )


            Text(
                text = "*아이디 또는 비밀번호가 잘못되었습니다",
                color = Red600,
                style = CVTheme.typography.captionRegular,
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 8.dp)
                    .fillMaxWidth()
            )

        CVLongButton(
            text = "로그인",
            onClick = {},
            enabled = true,
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
                .align(Alignment.CenterHorizontally)
                .clickable {  }
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
            NurseLoginScreen()
        }
    }
}
