package com.aurora.carevision.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Primary200
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVLongButton

@Composable
fun LoginScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.temporary_logo),
                contentDescription = "CareVision Logo",
                modifier = Modifier.padding(80.dp)
            )
            Text(
                text = stringResource(R.string.start_login_description),
                style = CVTheme.typography.headingPrimary,
                color = Black,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }

        Spacer(
            Modifier
                .height(16.dp)
                .weight(1f))

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CVLongButton(text = stringResource(R.string.text_login), onClick = { /*TODO*/ })
            Spacer(Modifier.height(16.dp))
            CVLongButton(
                text = stringResource(R.string.text_signup),
                onClick = { /*TODO*/ },
                backgroundColor = Primary200,
                textColor = Primary700
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.text_are_you_administrator),
                style = CVTheme.typography.textBody2Importance,
                color = Primary700,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .clickable { /*TODO*/ },
                textDecoration = TextDecoration.Underline
            )
        }
    }

}

@Composable
@Preview
fun LoginScreenPreview() {
    CVTheme {
        LoginScreen()
    }
}
