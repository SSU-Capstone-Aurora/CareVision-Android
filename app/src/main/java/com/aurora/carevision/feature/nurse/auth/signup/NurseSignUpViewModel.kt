package com.aurora.carevision.feature.nurse.auth.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.domain.nurse.repository.NurseAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NurseSignUpViewModel @Inject constructor(
    private val nurseAuthRepository: NurseAuthRepository
) : ViewModel() {

    val _state: MutableStateFlow<NurseSignUpState> = MutableStateFlow(NurseSignUpState())
    val state: MutableStateFlow<NurseSignUpState> = _state

    val _sideEffect: MutableStateFlow<NurseSignUpSideEffect?> = MutableStateFlow(null)
    val sideEffect: MutableStateFlow<NurseSignUpSideEffect?> = _sideEffect

    fun updateSelectedHospital(newHospitalName: String) {
        _state.value = _state.value.copy(selectedHospitalName = newHospitalName)
        Log.d("NurseSignUpViewModel", "updatedHospital : ${_state.value.selectedHospitalName}")
    }

    fun updateSelectedDepartment(newDepartment: String) {
        _state.value = _state.value.copy(selectedDepartment = newDepartment)
    }

    fun updateUserName(newUserName: String) {
        _state.value = _state.value.copy(userName = newUserName)
    }

    fun updateUserId(newUserId: String) {
        _state.value = _state.value.copy(userId = newUserId)
    }

    fun updatePassword(newPassword: String) {
        _state.value = _state.value.copy(password = newPassword)
        Log.d(
            "NurseSignUpViewModel",
            "updatedHospital : ${_state.value.selectedHospitalName}, updatedDepartment : ${_state.value.selectedDepartment}, updatedUserName : ${_state.value.userName}, updatedUserId : ${_state.value.userId}, updatedPassword : ${_state.value.password}"
        )
    }

    fun updateDoCheckNameDuplicate(newDoCheckNameDuplicate: Boolean) {
        _state.value = _state.value.copy(doCheckNameDuplicate = newDoCheckNameDuplicate)
    }

    fun checkPwValidation(): Boolean {
        val pattern = Regex("^(?=.*[A-Za-z])(?=.*[0-9]).{8,}\$")
        return pattern.matches(_state.value.password)
    }

    fun checkIdValidation() {
        viewModelScope.launch {
            runCatching {
                nurseAuthRepository.checkUsername(_state.value.userName)
                _state.value = _state.value.copy(doCheckNameDuplicate = true)
            }.onSuccess {
                _state.value = _state.value.copy(nameDuplicate = true)
                Log.d("NurseSignUpViewModel", "checkIdValidation : onSuccess")
            }.onFailure {
                _state.value = _state.value.copy(nameDuplicate = false)
                Log.d("NurseSignUpViewModel", "checkIdValidation : onFailure")
            }
        }
    }

    fun loadHospitalList(){
        viewModelScope.launch {
            runCatching {
                nurseAuthRepository.getNurseHospitalList()
            }.onSuccess {
                _state.value.hospitalList = it.hospitals
                Log.d("NurseSignUpViewModel", "loadHospitalList : onSuccess ${it.hospitals}")
            }.onFailure {
                Log.d("NurseSignUpViewModel", "loadHospitalList : onFailure : ${it.message}")
            }
        }
    }

    fun requestSignUp() {
        // 회원가입 API 호출
    }

    fun getHospitalList() {
        // 병원명 조회 API 호출
        viewModelScope.launch {
        }
    }
}