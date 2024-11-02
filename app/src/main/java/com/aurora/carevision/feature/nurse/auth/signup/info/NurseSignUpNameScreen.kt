package com.aurora.carevision.feature.nurse.auth.signup.info

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVBasicTextField
import com.aurora.carevision.core.component.CVDuplicateCheckTextField
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVSignInPasswordTextField
import com.aurora.carevision.core.component.TopAppBarLeft

@Composable
fun NurseSignUpNameScreen(
    navigateToBack: () -> Unit = {},
    navigateToNext: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize().background(White).systemBarsPadding().statusBarsPadding()
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

        CVBasicTextField(
            value = "",
            placeholder = "이름을 입력해주세요",
            label = "아이디",
            onTextChanged = { },
            onFocusChanged = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
        )

        CVLongButton(
            text = "다음",
            onClick = navigateToNext,
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )
    }
}

@Composable
@Preview
fun NurseSignUpNameScreenPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ) {
            NurseSignUpNameScreen()
        }
    }
}