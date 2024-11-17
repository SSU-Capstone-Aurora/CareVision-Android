package com.aurora.carevision.feature.admin.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.feature.nurse.auth.login.NurseLoginSideEffect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch


@HiltViewModel
class AdminLoginViewModel @Inject constructor(

) : ViewModel(){

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

    fun adminLogin() {
        viewModelScope.launch {
            Log.d(
                "adminLoginViewModel",
                "adminLogin: ${_state.value.userId} ${_state.value.password}"
            )
            if (_state.value.userId.isNotBlank() && _state.value.password.isNotBlank()) {
                _sideEffect.emit(AdminLoginSideEffect.NavigateToHome)
                _sideEffect.emit(AdminLoginSideEffect.ShowToast("로그인 클릭"))
            } else {
                _state.value = _state.value.copy(isLoginError = true)
                _sideEffect.emit(AdminLoginSideEffect.ShowToast("아이디 또는 비밀번호가 잘못되었습니다"))
            }
        }
    }
}
