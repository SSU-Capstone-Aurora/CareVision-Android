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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVDuplicateCheckTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVPasswordTextField
import com.aurora.carevision.core.component.TopAppBarLeft

@Composable
fun AdminNameInfoScreen(){
    //Text(text = "Signin")
    var isError by remember{ mutableStateOf(false) }
    var isTyping by remember { mutableStateOf(false) }
    var isFieldVisible by remember { mutableStateOf(false) }
    val correctUserID = "admin"
    val correctPassword = "password"
    var userName by rememberSaveable { mutableStateOf("") }

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
        CVBasicTextField(
            value = userName,
            placeholder = "이름을 입력해주세요",
            label = "이름",
            onTextChanged = {
                    text ->
                userName = text
                isTyping = text.isNotEmpty()
            },
            onFocusChanged = {
                    focused ->
                if(!focused) {
                    isTyping = false}
            },
            modifier = Modifier
                .fillMaxWidth()

        )
        Spacer(modifier = Modifier.padding())

        CVLongButton(
            text = "다음",
            onClick = {isFieldVisible = true},
            enabled = userName.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth() // 완료 버튼 크기 조절 필요
                .padding(top = 24.dp)
        )
    }
}

@Composable
@Preview
fun AdminHospitalCreationScreenPreview(){
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
