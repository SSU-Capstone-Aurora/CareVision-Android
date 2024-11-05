package com.aurora.carevision.feature.nurse.auth.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class NurseSignUpViewModel @Inject constructor(

): ViewModel() {

    val _state: MutableStateFlow<NurseSignUpState> = MutableStateFlow(NurseSignUpState())
    val state: MutableStateFlow<NurseSignUpState> = _state

    val _sideEffect: MutableStateFlow<NurseSignUpSideEffect?> = MutableStateFlow(null)
    val sideEffect: MutableStateFlow<NurseSignUpSideEffect?> = _sideEffect

    fun updateSelectedHospital(newHospitalName: String) {
        _state.value = _state.value.copy(hospitalName = newHospitalName)
    }

    fun updateSelectedDepartment(newDepartment: String) {
        _state.value = _state.value.copy(department = newDepartment)
    }

    fun updateUserName(newUserName: String) {
        _state.value = _state.value.copy(userName = newUserName)
    }

    fun updateUserId(newUserId: String) {
        _state.value = _state.value.copy(userId = newUserId)
    }

    fun updatePassword(newPassword: String) {
        _state.value = _state.value.copy(password = newPassword)
        Log.d("NurseSignUpViewModel", "updatedHospital : ${_state.value.hospitalName}, updatedDepartment : ${_state.value.department}, updatedUserName : ${_state.value.userName}, updatedUserId : ${_state.value.userId}, updatedPassword : ${_state.value.password}")
    }

    fun checkPwValidation(): Boolean {
        val pattern = Regex("^(?=.*[A-Za-z])(?=.*[0-9]).{8,}\$")
        return pattern.matches(_state.value.password)
    }

    fun checkIdValidation(): Boolean {
        // 중복확인 API 호출
        return false
    }
}