package com.aurora.carevision.feature.admin.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch


@HiltViewModel
class AdminLoginViewModel @Inject constructor() : ViewModel(){
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

    fun onLoginClick() {
        viewModelScope.launch {
            if (_state.value.userId == "admin" && _state.value.password == "password") { //TODO db에 있는 데이터와 비교해야함
                _sideEffect.emit(AdminLoginSideEffect.NavigateToHome)
            }
            else {
                _state.value = _state.value.copy(isLoginError = true)
                Log.d("AdminLoginViewModel","Login failed")
                }
            }
        }

    fun onSignUpClick() {
        viewModelScope.launch {
            _sideEffect.emit(AdminLoginSideEffect.OnSignUpClick)
        }
    }

    fun onLogInClick() {
        viewModelScope.launch {
            _sideEffect.emit(AdminLoginSideEffect.OnLoginClick)
        }
    }
    fun onBackClick() {
        viewModelScope.launch {
            _sideEffect.emit(AdminLoginSideEffect.OnBackClick)
        }
    }
}
