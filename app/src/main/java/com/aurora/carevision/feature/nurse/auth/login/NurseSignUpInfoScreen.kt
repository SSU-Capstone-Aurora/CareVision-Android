package com.aurora.carevision.feature.nurse.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVDuplicateCheckTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVSignInPasswordTextField
import com.aurora.carevision.core.component.TopAppBarLeft

@Composable
fun NurseSignUpInfoScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(White)
    ) {
        TopAppBarLeft()
        Text(
            text = "가입을 위한 정보를\n입력해주세요",
            style = CVTheme.typography.headingPrimary,
            color = Black,
            modifier = Modifier
                .padding(top = 16.dp, start = 24.dp, end = 24.dp, bottom = 24.dp)
        )
        CVDuplicateCheckTextField(
            value = "",
            placeholder = "아이디를 입력해주세요",
            label = "아이디",
            onTextChanged = { },
            onFocusChanged = { },
            onDuplicateCheck = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
        )
        Spacer(modifier = Modifier.padding())
        CVSignInPasswordTextField(
            value = "",
            isError = true,
            placeholder = "비밀번호를 입력해주세요",
            label = "비밀번호",
            onTextChanged = { },
            onFocusChanged = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
        )

        Text(
            text = "* 8글자 이상이어야 합니다",
            color = Red600,
            style = CVTheme.typography.captionRegular,
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp, horizontal = 24.dp)
        )

        Text(
            text = "* 숫자가 들어가야 합니다",
            color = Red600,
            style = CVTheme.typography.captionRegular,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)
        )

        CVLongButton(
            text = "완료",
            onClick = {},
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )
    }
}

@Composable
@Preview
fun NurseSignUpInfoScreenPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ) {
            NurseSignUpInfoScreen()
        }
    }
}