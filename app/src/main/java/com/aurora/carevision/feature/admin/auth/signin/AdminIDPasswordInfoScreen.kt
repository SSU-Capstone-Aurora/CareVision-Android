package com.aurora.carevision.feature.admin.auth.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVDuplicateCheckTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVPasswordTextField
import com.aurora.carevision.core.component.CVSignInPasswordTextField
import com.aurora.carevision.core.component.TopAppBarLeft

@Composable
fun AdminIDPasswordInfoScreen(){
    //Text(text = "Signin")
    var isError by remember{ mutableStateOf(false) }
    var isTyping by remember { mutableStateOf(false) }
    var isFieldVisible by remember { mutableStateOf(false) }
    val correctUserID = "admin"
    val correctPassword = "password"
    var userID by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var errorMessageCount by remember { mutableStateOf(false)}
    var errorMessageNoInt by remember { mutableStateOf(false)}

    fun validatePassword(password: String) {
        errorMessageCount = password.length < 8
        errorMessageNoInt = !password.any { it.isDigit() }
        isError = errorMessageCount || errorMessageNoInt
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(top = 52.dp, start = 24.dp, end = 24.dp),
    ){
        TopAppBarLeft()
        Text(
            text = "가입을 위한 정보를\n입력해주세요",
            style = CVTheme.typography.headingPrimary,
            color = Black,
            modifier = Modifier
                .padding(top=16.dp, bottom = 24.dp)
        )
        CVDuplicateCheckTextField(
            value = userID,
            placeholder = "아이디를 입력해주세요",
            label = "아이디",
            onTextChanged = {
                text ->
                userID = text
                isTyping = text.isNotEmpty()
                },
            onFocusChanged = {
                focused ->
                if(!focused) {
                    isTyping = false}
            },
            onDuplicateCheck = {}, // 구현해야함
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )
        Spacer(modifier = Modifier.padding())
        CVSignInPasswordTextField(
            value = password,
            isError = errorMessageCount || errorMessageNoInt ,
            placeholder = "비밀번호를 입력해주세요",
            label = "비밀번호",
            onTextChanged = {
                password = it
            },
            onFocusChanged = {},
            modifier = Modifier
                .fillMaxWidth()
        )
        if(errorMessageCount){
            Text(
                text = "* 8글자 이상이어야 합니다",
                color = Red600,
                style = CVTheme.typography.captionRegular,
                modifier = Modifier.padding(top = 4.dp, start = 12.dp)
            )
        }
        if(errorMessageNoInt){
            Text(
                text = "* 숫자가 들어가야 합니다",
                color = Red600,
                style = CVTheme.typography.captionRegular,
                modifier = Modifier.padding(top = 4.dp, start = 12.dp)
            )
        }
        CVLongButton(
            text = "완료",
            onClick = {
                validatePassword(password)
                if (password.isNotEmpty() && !errorMessageCount && !errorMessageNoInt) {
                    isFieldVisible = true
                }
                      },
            enabled = password.isNotEmpty() && userID.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth() // 완료 버튼 크기 조절 필요
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

