package com.aurora.carevision.feature.nurse.auth.signup

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVTailIconSearchBar
import com.aurora.carevision.core.component.TopAppBarLeft

@Composable
fun NurseSignUpScreen(
    navigateToBack: () -> Unit = {},
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .statusBarsPadding()
            .systemBarsPadding()
    ){
        TopAppBarLeft(
            onClick =  navigateToBack
        )
        Text(
            text = "환영합니다!\n어디에서 근무 중이신가요?",
            style = CVTheme.typography.headingPrimary,
            color = Color.Black,
            modifier = Modifier
                .padding(top=16.dp, start = 24.dp, end = 24.dp, bottom = 24.dp)
        )

        CVTailIconSearchBar(
            value = "",
            onValueChange = {},
            placeholder = "병원 이름을 입력하세요",
            onTextChanged = { },
            onFocusChanged = { }
        )
        Spacer(modifier = Modifier.height(24.dp))
        CVTailIconSearchBar(
            value = "",
            onValueChange = {},
            placeholder = "과를 선택해주세요",
            onTextChanged = { },
            onFocusChanged = { }
        )

        CVLongButton(
            text = "다음",
            onClick = { },
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )
    }
}

@Composable
@Preview
fun NurseSignUpScreenPreview(){
    CVTheme{
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ){
            NurseSignUpScreen()
        }
    }
}