package com.aurora.carevision.feature.admin.auth.request

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
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.core.component.CVTopAppBar

// img_has_no_alarm_png
@Composable
fun AdminRequestNullScreen() {
    CVTopAppBar(title = "간호사 요청")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(top = 52.dp, start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.img_has_no_alarm),
            contentDescription = "Login Loading Image",
            modifier = Modifier
                .size(width = 341.dp, height = 267.dp) //TODO 이미지 크기 설정 다시 해야 함
        )
        Text(
            text = "알림이 없습니다",
            style = CVTheme.typography.headingSecondary,
            color = Color.Black,
            modifier = Modifier.padding(top = 36.dp)
        )
    }
}


@Composable
@Preview
fun AdminRequestNullPreview() {

    CVTheme {
        Column(
            modifier = Modifier
                .background(Black)
                .fillMaxSize()
        ) {
            AdminRequestNullScreen()
        }
    }
}





