package com.aurora.carevision.core.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Primary500
import com.aurora.carevision.app.ui.theme.White

@Composable
fun LoadingScreen(
    text: String? = null,
    loadingImage: Int? = null,
    navigateToNextScreen: () -> Unit = {}
){
    Column(
        modifier = Modifier.fillMaxSize().background(White),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {

        if(loadingImage == null) {
            CircularProgressIndicator(color = Primary500, strokeWidth = 17.dp, modifier = Modifier.width(100.dp).height(100.dp))
        } else {
            Image(
                painter = painterResource(id = R.drawable.ic_profile_frame_32),
                contentDescription = "CareVision Logo",
                modifier = Modifier.padding(80.dp)
            )
        }

        Spacer(Modifier.height(36.dp))

        Text(
            text = text ?: stringResource(R.string.loading_default),
            style = CVTheme.typography.headingPrimary,
            color = Black,
        )
    }
}

@Composable
@Preview
fun LoadingScreenPreview() {
    CVTheme {
        LoadingScreen()
    }
}