package com.aurora.carevision.feature.admin.auth.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White

@Composable
fun AdminSignInCompletionScreen(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_signin_complete_icon),
            contentDescription = "Login Loading Image",
            modifier = Modifier
                .size(150.dp) //TODO 이미지 크기 설정 다시 해야 함
        )

        Text(
            text = "회원가입이 완료되었습니다",
            style = CVTheme.typography.headingPrimary,
            color = Color.Black,
            modifier = Modifier.padding(top = 36.dp)
        )
    }
}

@Composable
@Preview
fun AdminSignInCompletionScreenPreview(){
    CVTheme{
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ){
            AdminSignInCompletionScreen()
        }
    }
}

