package com.aurora.carevision.data.remote.nurse.fcm.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import com.aurora.carevision.R
import com.aurora.carevision.app.MainActivity
import com.aurora.carevision.data.local.auth.TokenProvider
import com.aurora.carevision.data.remote.nurse.fcm.model.FCMRequestBody
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

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCM 호출", "onNewToken 호출됨")

        // 토큰 저장
        tokenProvider.saveFCMToken(token)

        // 토큰 서버 전송
        CoroutineScope(Dispatchers.IO).launch {
            firebaseTokenService.sendRegistrationToken(
                FCMRequestBody(tokenProvider.getUserName().toString(), token)
            )
        }
    }

    // 메시지 수신 시 호출
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d("FCM 호출", "onMessageReceived 호출됨")

        // `data` 속 정보 파싱
        val data = remoteMessage.data
        val patientName = data["patientName"] ?: "이름 없음"
        val patientRoomNumber = data["patientRoomNumber"] ?: "알 수 없음"
        val bedNumber = data["bedNumber"] ?: "알 수 없음"
        val time = data["time"] ?: "시간 없음"

        Log.d("FCM", "Patient Name: $patientName, Room: $patientRoomNumber, Bed: $bedNumber, Time: $time")

        // 알림 생성
        val title = "$patientName 환자 이상행동 감지"
        val body = "${patientRoomNumber}병실 ${bedNumber}베드에서 이상행동 감지되었습니다." //감지 시각: ${extractTime(time)}
        showNotification(title, body)
    }


    private fun showNotification(title: String?, body: String?) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "이상행동감지알림채널ID"

        // 알림 채널 생성 (필요시)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "이상행동감지알림채널",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }

        // PendingIntent 생성 (MainActivity로 이동)
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("source", "notification") // 추가 데이터 전달 가능
        }

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // BigTextStyle 설정
        val bigTextStyle = NotificationCompat.BigTextStyle()
            .bigText(body ?: "알림 내용이 없습니다.") // 확장 시 보여줄 긴 텍스트
            .setBigContentTitle(title ?: "이상행동 감지 알림") // 확장 시 제목
            .setSummaryText("CareVision") // 알림 요약 텍스트

        // 알림 생성
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title ?: "알림")
            .setContentText("$body\n이상행동이 감지되었습니다.")
            .setSmallIcon(R.drawable.ic_alarm)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent) // 알림 클릭 시 실행될 PendingIntent 설정
            .setAutoCancel(true) // 알림 클릭 시 자동 삭제
            .setStyle(bigTextStyle) // BigTextStyle 적용
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        notificationManager.notify(0, notification)
    }
}