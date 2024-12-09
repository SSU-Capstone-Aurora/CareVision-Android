package com.aurora.carevision.feature.nurse.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.data.local.auth.TokenProvider
import com.aurora.carevision.data.remote.nurse.fcm.model.FCMRequestBody
import com.aurora.carevision.data.remote.nurse.fcm.service.FirebaseTokenService
import com.aurora.carevision.domain.nurse.model.auth.NurseUser
import com.aurora.carevision.domain.nurse.repository.NurseAuthRepository
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NurseLoginViewModel @Inject constructor(
    private val nurseAuthRepository: NurseAuthRepository,
    private val tokenProvider: TokenProvider,
    private val firebaseTokenService: FirebaseTokenService
) : ViewModel() {

    private val _state = MutableStateFlow(NurseLoginState())
    val state: MutableStateFlow<NurseLoginState> = _state

    private val _sideEffect = MutableStateFlow<NurseLoginSideEffect?>(null)
    val sideEffect: MutableStateFlow<NurseLoginSideEffect?> = _sideEffect

    fun onUserIdChange(newUserId: String) {
        _state.value = _state.value.copy(userId = newUserId)
        Log.d("NurseLoginViewModel", "onUserIdChange: ${_state.value.userId}")
    }

    fun onPasswordChange(newPassword: String) {
        _state.value = _state.value.copy(password = newPassword)
        Log.d("NurseLoginViewModel", "onPasswordChange: ${_state.value.password}")
    }

    fun nurseLogin(userId: String, password: String) {
        viewModelScope.launch {
            runCatching {
                nurseAuthRepository.nurseLogin(NurseUser(userId = userId, password = password))
            }.onSuccess{
                _sideEffect.value = NurseLoginSideEffect.LoginSuccess
                tokenProvider.saveAccessToken(it.accessToken)
                tokenProvider.saveRefreshToken(it.refreshToken)
                fetchFCMToken()
                Log.d("NurseLoginViewModel", "nurseLogin: ${_state.value.userId} ${_state.value.password}")
                Log.d("NurseLoginViewModel", "Token: ${it.accessToken} ${it.refreshToken}")
            }.onFailure {
                _sideEffect.value = NurseLoginSideEffect.ShowToast("로그인에 실패했습니다.\n다시 시도해주세요.")
                Log.d("NurseLoginViewModel", "nurseLogin: ${_state.value.userId} ${_state.value.password}")
            }
        }
    }


    // 알림 관련 FCM
    private fun fetchFCMToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("FCM token failed", "Fetching FCM registration token failed", task.exception)
                return@addOnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            Log.d("FCM new Token", "FCM registration token: $token")

            tokenProvider.saveFCMToken(token)
            Log.d("FCM in tokenProvider", "${tokenProvider.getFCMToken()}")

            sendFCMTokenToServer()
        }
    }

    private fun sendFCMTokenToServer() {
        val token = tokenProvider.getFCMToken() ?: return
        val username = _state.value.userId

        viewModelScope.launch {
            runCatching {
                firebaseTokenService.sendRegistrationToken(
                    FCMRequestBody(
                        username = username,
                        clientToken = token
                    )
                )
                Log.d("FCM Token Provider", "$username, $token")
            }.onSuccess {
                Log.d("FCM to Server Success", "FCM Token successfully sent to server.")
            }.onFailure {
                Log.e("FCM to Server Failed", "Failed to send FCM Token to server: ${it.message}")
            }
        }
    }
}
