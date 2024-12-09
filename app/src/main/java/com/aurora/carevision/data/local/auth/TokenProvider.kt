package com.aurora.carevision.data.local.auth

import android.content.SharedPreferences
import javax.inject.Inject

// 앱에서 사용되는 토큰을 관리 및 저장하는 클래스
class TokenProvider @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    companion object {
        private const val ACCESS_TOKEN_KEY = "access_token"
        private const val REFRESH_TOKEN_KEY = "refresh_token"
        private const val FCM_TOKEN_KEY = "fcm_token"
    }

    // 액세스 토큰을 가져오는 메서드
    fun getAccessToken(): String? {
        return sharedPreferences.getString(ACCESS_TOKEN_KEY, null)
    }

    // 리프레시 토큰을 가져오는 메서드
    fun getRefreshToken(): String? {
        return sharedPreferences.getString(REFRESH_TOKEN_KEY, null)
    }

    // 새로운 액세스 토큰을 저장하는 메서드
    fun saveAccessToken(token: String) {
        sharedPreferences.edit().putString(ACCESS_TOKEN_KEY, token).apply()
    }

    // 새로운 리프레시 토큰을 저장하는 메서드
    fun saveRefreshToken(token: String) {
        sharedPreferences.edit().putString(REFRESH_TOKEN_KEY, token).apply()
    }

    // 토큰을 모두 삭제하는 메서드 (로그아웃 시 등)
    fun clearTokens() {
        sharedPreferences.edit().remove(ACCESS_TOKEN_KEY).remove(REFRESH_TOKEN_KEY).apply()
    }

    // FCM 토큰을 저장하는 메서드
    fun saveFCMToken(fcmToken: String): Boolean {
        return sharedPreferences.edit().putString(FCM_TOKEN_KEY, fcmToken).commit()
    }

    // FCM 토큰을 가져오는 메서드
    fun getFCMToken(): String? {
        return sharedPreferences.getString(FCM_TOKEN_KEY, null)
    }

    // 유저 이름 저장
    fun saveUserName(userName: String): Boolean {
        return sharedPreferences.edit().putString("user_name", userName).commit()
    }

    // 유저 이름 가져오기
    fun getUserName(): String? {
        return sharedPreferences.getString("user_name", null)
    }

    fun saveUserId(userId: String): Boolean {
        return sharedPreferences.edit().putString("user_id", userId).commit()
    }

    fun getUserId(): String? {
        return sharedPreferences.getString("user_id", null)
    }
}
