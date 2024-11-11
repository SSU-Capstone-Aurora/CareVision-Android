package com.aurora.carevision.feature.nurse.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NurseLoginViewModel @Inject constructor(

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

    // TODO 서버통신 적용
    fun nurseLogin() {
        viewModelScope.launch {
            Log.d("NurseLoginViewModel", "nurseLogin: ${_state.value.userId} ${_state.value.password}")

            if (_state.value.userId.isNotBlank() && _state.value.password.isNotBlank()) {
                _sideEffect.emit(NurseLoginSideEffect.NavigateToHome)
                _sideEffect.emit(NurseLoginSideEffect.ShowToast("로그인 클릭"))
            } else {
                _state.value = _state.value.copy(isLoginError = true)
                _sideEffect.emit(NurseLoginSideEffect.ShowToast("아이디 또는 비밀번호가 잘못되었습니다"))
            }
        }
    }
}
