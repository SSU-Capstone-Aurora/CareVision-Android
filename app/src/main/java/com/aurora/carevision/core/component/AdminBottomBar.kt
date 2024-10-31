package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Primary600
import com.aurora.carevision.app.ui.theme.White

@Composable
fun AdminBottomBar(
    navigateToHome: () -> Unit = {},
    navigateToPatientRegister: () -> Unit = {},
    navigateToNotification: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 50.dp)
                .clickable { navigateToHome() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home_line),
                contentDescription = "Bottom Navigation Icon",
                tint = Gray500
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "홈",
                textAlign = TextAlign.Center,
                style = CVTheme.typography.captionImportance,
                color = Gray500
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(end = 50.dp)
                .clickable { navigateToNotification() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bell_bottom_navi_line),
                contentDescription = "Bottom Navigation Icon",
                tint = Gray500
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "요청",
                textAlign = TextAlign.Center,
                style = CVTheme.typography.captionImportance,
                color = Gray500
            )
        }
    }
}

@Composable
@Preview
fun AdminBottomBarPreview() {
    CVTheme {
        AdminBottomBar()
    }
}