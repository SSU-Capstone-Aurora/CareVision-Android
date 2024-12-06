package com.aurora.carevision.data.remote.nurse.fcm.service

import android.app.NotificationManager
import android.content.Context
import android.util.Log
import androidx.core.app.NotificationCompat
import com.aurora.carevision.R
import com.aurora.carevision.data.local.auth.TokenProvider
import com.aurora.carevision.data.remote.nurse.fcm.model.FCMRequestBody
import com.aurora.carevision.data.remote.nurse.fcm.service.FirebaseTokenService
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AppFirebaseMessagingService : FirebaseMessagingService() {

    @Inject
    lateinit var tokenProvider: TokenProvider

    @Inject
    lateinit var firebaseTokenService: FirebaseTokenService

    // 토큰이 갱신될 때 호출
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCM", "Refreshed token: $token")
        // 토큰 저장 및 서버로 전송
        handleTokenUpdate(token)
    }

    // 메시지 수신 시 호출
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // 알림 데이터 확인
        remoteMessage.notification?.let {
            Log.d("FCM", "Message Notification Title: ${it.title}")
            Log.d("FCM", "Message Notification Body: ${it.body}")
        }

        remoteMessage.data.let {
            Log.d("FCM", "Message Data: $it")
        }

        // 알림 생성
        showNotification(remoteMessage.notification?.title, remoteMessage.notification?.body)
    }

    private fun handleTokenUpdate(token: String) {
        // 1. 토큰을 SharedPreferences에 저장
        tokenProvider.saveFCMToken(token)

        // 2. 서버에 전송
        val username = tokenProvider.getAccessToken() ?: return
        val requestBody = FCMRequestBody(username = username, clientToken = token)

        CoroutineScope(Dispatchers.IO).launch {
            kotlin.runCatching {
                firebaseTokenService.sendRegistrationToken(requestBody)
            }.onSuccess {
                Log.d("FCM", "FCM Token successfully sent to server.")
            }.onFailure {
                Log.e("FCM", "Failed to send FCM Token to server: ${it.message}")
            }
        }
    }

    private fun showNotification(title: String?, body: String?) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(this, "default")
            .setContentTitle(title ?: "알림")
            .setContentText(body ?: "새로운 알림이 도착했습니다.")
            .setSmallIcon(R.drawable.ic_alarm)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(0, notification)
    }
}
