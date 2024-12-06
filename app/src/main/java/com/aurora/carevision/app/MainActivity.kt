package com.aurora.carevision.app

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.data.local.auth.TokenProvider
import com.aurora.carevision.feature.intro.Intro
import com.aurora.carevision.navigation.CVNavHost
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        enableEdgeToEdge()
        setContent {
            CVTheme {
                // navController를 생성하고, 이를 NavHost에 전달
                val navController = rememberNavController()
                val context = LocalContext.current

                // 권한 요청 런처
                val requestPermissionLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestPermission()
                ) { isGranted ->
                    if (isGranted) {
                        Toast.makeText(context, "알림 권한이 허용되었습니다.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "알림 권한이 거부되었습니다.", Toast.LENGTH_SHORT).show()
                    }
                }

                // 권한 요청 함수 호출
                LaunchedEffect(Unit) {
                    askNotificationPermission(context, requestPermissionLauncher)
                }

                CVNavHost(
                    navController = navController,
                    startDestination = Intro,
                )
            }
        }
    }

    private fun askNotificationPermission(
        context: Context,
        requestPermissionLauncher: ActivityResultLauncher<String>
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when {
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED -> {
                    // 권한이 이미 허용됨
                }

                shouldShowRequestPermissionRationale(this, Manifest.permission.POST_NOTIFICATIONS) -> {
                    Toast.makeText(
                        context,
                        "알림을 활성화하려면 권한이 필요합니다.",
                        Toast.LENGTH_LONG
                    ).show()
                    requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }

                else -> {
                    // 권한 요청
                    requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            }
        }
    }
}
