package com.aurora.carevision.manager.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White

@Composable
fun AdminSignInCompletionScreen(){
    Text(text = "Sign Up Completion")
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

