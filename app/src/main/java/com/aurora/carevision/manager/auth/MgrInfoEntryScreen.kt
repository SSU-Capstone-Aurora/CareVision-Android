package com.aurora.carevision.manager.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aurora.carevision.ui.theme.CVTheme
import com.aurora.carevision.ui.theme.White

@Composable
fun MgrInfoEntryScreen(){
    Text(text = "Manager Information")
}

@Composable
@Preview
fun MgrInfoEntryScreenPreview(){
    CVTheme{
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ){
            MgrInfoEntryScreen()
        }
    }
}

