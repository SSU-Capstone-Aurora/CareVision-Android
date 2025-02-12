package com.aurora.carevision.feature.nurse.auth.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.domain.nurse.model.auth.NurseUser
import com.aurora.carevision.domain.nurse.repository.NurseAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NurseSignUpViewModel @Inject constructor(
    private val nurseAuthRepository: NurseAuthRepository
) : ViewModel() {

    val _state: MutableStateFlow<NurseSignUpState> = MutableStateFlow(NurseSignUpState())
    val state: MutableStateFlow<NurseSignUpState> = _state

    val _sideEffect: MutableSharedFlow<NurseSignUpSideEffect?> = MutableSharedFlow()
    val sideEffect: MutableSharedFlow<NurseSignUpSideEffect?> = _sideEffect

    fun updateSelectedHospital(newHospitalName: String, newHospitalId: Int) {
        _state.value = _state.value.copy(
            selectedHospitalName = newHospitalName,
            selectedHospitalId = newHospitalId
        )
    }

    fun updateSelectedDepartment(newDepartmentName: String, newDepartmentId: Int) {
        _state.value = _state.value.copy(
            selectedDepartmentName = newDepartmentName,
            selectedDepartmentId = newDepartmentId
        )
    }

    fun updateUserName(newUserName: String) {
        _state.value = _state.value.copy(userName = newUserName)
    }

    fun updateUserId(newUserId: String) {
        _state.value = _state.value.copy(userId = newUserId)
    }

    fun updatePassword(newPassword: String) {
        _state.value = _state.value.copy(password = newPassword)
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

    fun loadHospitalList() {
        viewModelScope.launch {
            runCatching {
                nurseAuthRepository.getNurseHospitalList()
            }.onSuccess {
                _state.value = _state.value.copy(hospitalList = it.hospitals) // copy 사용
                Log.d("NurseSignUpViewModel", "loadHospitalList : onSuccess ${it.hospitals}")
            }.onFailure {
                Log.d("NurseSignUpViewModel", "loadHospitalList : onFailure : ${it.message}")
            }
        }
    }

    fun loadDepartmentList(selectedHospitalId: Int) {
        viewModelScope.launch {
            runCatching {
                nurseAuthRepository.getNurseDepartmentList(selectedHospitalId)
            }.onSuccess {
                _state.value = _state.value.copy(departmentList = it.departments) // copy 사용
                Log.d("NurseSignUpViewModel", "loadDepartmentList : onSuccess ${it.departments}")
            }.onFailure {
                Log.d("NurseSignUpViewModel", "loadDepartmentList : onFailure : ${it.message}")
            }
        }
    }

    fun requestSignUp() {
        viewModelScope.launch {
            runCatching {
                nurseAuthRepository.nurseSignUp(
                    NurseUser(
                        name = _state.value.userName,
                        userId = _state.value.userId,
                        password = _state.value.password,
                        hospitalId = _state.value.selectedHospitalId,
                        departmentId = _state.value.selectedDepartmentId
                    )
                )
            }.onSuccess {
                _sideEffect.emit(NurseSignUpSideEffect.SignUpSuccess)
                Log.d("NurseSignUpViewModel", "requestSignUp : onSuccess")
            }.onFailure {
                _sideEffect.emit(NurseSignUpSideEffect.ShowToast(it.message ?: "회원가입 실패"))
                Log.d("NurseSignUpViewModel", "requestSignUp : onFailure : ${it.message}")
            }
        }
    }
}