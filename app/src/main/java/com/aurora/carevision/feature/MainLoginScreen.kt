package com.aurora.carevision.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.app.ui.theme.Primary200
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVBasicButton

@Composable
fun MainLoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(id = R.drawable.temporary_logo),
            contentDescription = "Temporary Logo",
            modifier = Modifier.size(200.dp).background(Primary700).fillMaxWidth().weight(2f),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "믿을 수 있는 환자 모니터링,\n케어비전과 함께 안심하세요",
            style = CVTheme.typography.headingPrimary,
            color = Gray700,
            modifier = Modifier.fillMaxWidth().weight(1f),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        CVBasicButton(text = "로그인", onClick = { /*TODO*/ }, modifier = Modifier.padding(horizontal = 24.dp))
        Spacer(modifier = Modifier.height(16.dp))
        CVBasicButton(text = "회원가입", onClick = { /*TODO*/ }, modifier = Modifier.padding(horizontal = 24.dp), backgroundColor = Primary200, textColor = Primary700)
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "관리자 이신가요?",
            style = CVTheme.typography.textBody2Importance,
            color = Primary700,
            modifier = Modifier.fillMaxWidth().weight(1f).clickable { /*TODO*/ },
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun MainLoginScreenPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ) {
            MainLoginScreen()
        }
    }
}