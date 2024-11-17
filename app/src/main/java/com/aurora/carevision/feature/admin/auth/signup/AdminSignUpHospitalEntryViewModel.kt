package com.aurora.carevision.feature.admin.auth.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminSignUpHospitalEntryViewModel @Inject constructor(

): ViewModel(){

    val _state : MutableStateFlow<AdminSignUpHospitalEntryState> = MutableStateFlow(AdminSignUpHospitalEntryState())
    val state: StateFlow<AdminSignUpHospitalEntryState> = _state


    val _sideEffect: MutableStateFlow<AdminSignUpHospitalEntrySideEffect?> = MutableStateFlow(null)
    val sideEffect: MutableStateFlow<AdminSignUpHospitalEntrySideEffect?> = _sideEffect

    fun updateSelectedHospital(newHospitalName: String) {
        _state.value = _state.value.copy(hospitalName = newHospitalName, isHospitalSelected = true)
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
        Log.d("AdminignUpViewModel", "updatedHospital : ${_state.value.hospitalName}, updatedDepartment : ${_state.value.department}, updatedUserName : ${_state.value.userName}, updatedUserId : ${_state.value.userId}, updatedPassword : ${_state.value.password}")
    }

    fun checkPwValidation(): Boolean {
        val pattern = Regex("^(?=.*[A-Za-z])(?=.*[0-9]).{8,}\$")
        return pattern.matches(_state.value.password)
    }

    // Check ID validation (dummy for now)
    fun checkIdValidation(): Boolean {
        // 중복확인 API 호출 등 필요 시 사용
        return false
    }

    fun performHospitalSearch(query: String) {
        val results = listOf("seoul", "soongsil")
        _state.value = _state.value.copy(searchResults = results)
        // 병원 정보 조회 API 호출
    }

    fun requestSignUp() {
        // 실제 회원가입 API 호출
    }
}
