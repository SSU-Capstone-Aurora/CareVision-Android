package com.aurora.carevision.feature.nurse.auth.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.White

@Composable
fun NurseSignUpCompletionScreen(){
    Column (
        modifier = Modifier.fillMaxSize().background(White).systemBarsPadding().statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_signup_complete_icon),
            contentDescription = "Login Loading Image",
            modifier = Modifier
                .size(120.dp)
        )

        Text(
            text = "가입 요청이\n완료되었습니다",
            style = CVTheme.typography.headingPrimary,
            color = Color.Black,
            modifier = Modifier.padding(top = 36.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "관리자 승인 후 가입이 완료됩니다",
            style = CVTheme.typography.textBody1Importance,
            color = Gray500,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
@Preview
fun NurseSignUpCompletionScreenPreview(){
    CVTheme{
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ){
            NurseSignUpCompletionScreen()
        }
    }
}

