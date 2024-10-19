package com.aurora.carevision.feature.admin.auth.login

import android.service.controls.Control
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.compose.rememberNavController
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVBasicButton
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVPasswordTextField
import com.aurora.carevision.core.component.TopAppBarLeft

@Composable
fun AdminLoginScreen(){
    var userID by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isError by remember{ mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("")}
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(top = 52.dp, start = 24.dp, end = 24.dp)
    ){
        TopAppBarLeft()
        Text(
            text = "안녕하세요 :) \n케어비전입니다",
            style = CVTheme.typography.headingPrimary,
            color = Color.Black,
            modifier = Modifier
                .padding(top=16.dp, bottom = 24.dp)
        )
        CVBasicTextField(
            value = userID,
            //isError = isError && userID != correctUserID,
            placeholder = "아이디를 입력해주세요",
            label = "아이디",
            onTextChanged = {userID = it},
            onFocusChanged = {},
            modifier = Modifier
                .fillMaxWidth()

        )
        CVPasswordTextField(
            value = password,
            //isError = isError && password!= correctPassword,
            placeholder = "비밀번호를 입력해주세요",
            label = "비밀번호",
            onTextChanged = {password = it},
            onFocusChanged = {},
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
        )

        if(isError){
            Text(
                text = errorMessage,
                color = Red600,
                style = CVTheme.typography.captionRegular,
                modifier = Modifier
                    .padding(top = 8.dp, start = 12.dp)
                    .fillMaxWidth()
            )
        }
        CVLongButton(
            text = "로그인",
            onClick = {
//                if(userID == correctUserID && password == correctPassword){
//                    isError = false
//                    println("login successed")
//                }
//                else {
//                    isError = true
//                    errorMessage ="*아이디 또는 비밀번호가 잘못되었습니다"
//                    println("login failed")
//                }

            },
            enabled = userID.isNotEmpty() && password.isNotEmpty(),
            modifier = Modifier
                .padding(top = 24.dp)
        )
        Text( //TODO 버튼 형식으로 변형
            textDecoration = TextDecoration.Underline,
            text = "혹시 회원이 아니신가요?",
            style = CVTheme.typography.textBody2Medium,
            color = Primary700,
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
@Preview
fun LoginScreenPreview(){
    val correctUserID = "admin"
    val correctPassword = "password"
    CVTheme{
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ){
            AdminLoginScreen()
        }
    }
}


