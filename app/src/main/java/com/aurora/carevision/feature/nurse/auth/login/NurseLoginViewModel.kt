package com.aurora.carevision.feature.nurse.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.domain.nurse.model.auth.NurseUser
import com.aurora.carevision.domain.nurse.repository.NurseAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NurseLoginViewModel @Inject constructor(
    private val nurseAuthRepository: NurseAuthRepository
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
                Log.d("NurseLoginViewModel", "nurseLogin: ${_state.value.userId} ${_state.value.password}")
            }.onFailure {
                _sideEffect.value = NurseLoginSideEffect.ShowToast("로그인에 실패했습니다.\n다시 시도해주세요.")
                Log.d("NurseLoginViewModel", "nurseLogin: ${_state.value.userId} ${_state.value.password}")
            }
        }
    }
}
