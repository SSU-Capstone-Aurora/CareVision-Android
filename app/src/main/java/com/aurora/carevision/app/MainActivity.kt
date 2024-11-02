package com.aurora.carevision.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.feature.intro.Intro
import com.aurora.carevision.navigation.CVNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        enableEdgeToEdge()
        setContent {
            CVTheme {

                // navController를 생성하고, 이를 NavHost에 전달
                val navController = rememberNavController()

                // NavHost는 여러개의 composable을 가지고 있는데, 이 composable들을 관리하는 역할
                CVNavHost(
                    navController = navController,
                    startDestination = Intro,
                )
            }
        }
    }
}
