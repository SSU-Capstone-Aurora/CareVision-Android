package com.aurora.carevision.feature.admin.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.data.local.auth.TokenProvider
import com.aurora.carevision.domain.admin.model.auth.AdminUser
import com.aurora.carevision.domain.admin.repository.AdminAuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class AdminLoginViewModel @Inject constructor(
    private  val adminAuthRepository: AdminAuthRepository,
    private val tokenProvider: TokenProvider
) : ViewModel() {

    private val _state = MutableStateFlow(AdminLoginState())
    val state: MutableStateFlow<AdminLoginState> = _state

    private val _sideEffect = MutableStateFlow<AdminLoginSideEffect?>(null)
    val sideEffect: MutableStateFlow<AdminLoginSideEffect?> = _sideEffect

    fun onUserIdChange(newUserId: String) {
        _state.value = _state.value.copy(userId = newUserId)
        Log.d("AdminLoginViewModel", "onUserIdChange: ${_state.value.userId}")
    }

    fun onPasswordChange(newPassword: String) {
        _state.value = _state.value.copy(password = newPassword)
        Log.d("AdminLoginViewModel", "onPasswordChange: ${_state.value.password}")
    }

    fun adminLogin(userId: String, password: String) {
        viewModelScope.launch {
            runCatching {
                adminAuthRepository.adminLogin(AdminUser(userId = userId, password = password))
            }.onSuccess {
                _sideEffect.value = AdminLoginSideEffect.LoginSuccess
                tokenProvider.saveAccessToken(it.accessToken)
                tokenProvider.saveRefreshToken(it.refreshToken)
                Log.d(
                    "AdminLoginViewModel",
                    "adminLogin: ${_state.value.userId} ${_state.value.password}"
                )
                Log.d("AdminLoginViewModel", "Token: ${it.accessToken} ${it.refreshToken}")
            }.onFailure {
                _sideEffect.value = AdminLoginSideEffect.ShowToast("로그인에 실패했습니다.\n다시 시도해주세요.")
                Log.d(
                    "AdminLoginViewModel",
                    "adminLogin: ${_state.value.userId} ${_state.value.password}"
                )
            }
        }
    }
}
