package com.aurora.carevision.feature.admin.auth.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.data.remote.admin.auth.model.toDomainModel
import com.aurora.carevision.domain.admin.model.auth.AdminUser
import com.aurora.carevision.domain.admin.repository.AdminAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminSignUpHospitalEntryViewModel @Inject constructor(
    private val adminAuthRepository: AdminAuthRepository
): ViewModel(){

    val _state : MutableStateFlow<AdminSignUpHospitalEntryState> = MutableStateFlow(AdminSignUpHospitalEntryState())
    val state: StateFlow<AdminSignUpHospitalEntryState> = _state


    val _sideEffect: MutableStateFlow<AdminSignUpHospitalEntrySideEffect?> = MutableStateFlow(null)
    val sideEffect: MutableStateFlow<AdminSignUpHospitalEntrySideEffect?> = _sideEffect

    fun updateSelectedHospital(newHospitalName: String, newHospitalYkiho: String) {
        _state.value = _state.value.copy(
            selectedHospitalName = newHospitalName,
            selectedHospitalykiho = newHospitalYkiho,
            isHospitalSelected = true
        )
        Log.d("AdminSignUpViewModel", "updateSelectedHospital : ${newHospitalName}, ${newHospitalYkiho}")
    }

    fun updateSelectedDepartment(newDepartmentName: String) {
        _state.value = _state.value.copy(
            selectedDepartmentName = newDepartmentName,
        )
        Log.d("AdminSignUpViewModel", "updateSelectedDepartment : ${newDepartmentName}")
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

    fun checkPwValidation(): Boolean {
        val pattern = Regex("^(?=.*[A-Za-z])(?=.*[0-9]).{8,}\$")
        return pattern.matches(_state.value.password)
    }

    fun updateDoCheckNameDuplicate(newDoCheckNameDuplicate: Boolean) {
        _state.value = _state.value.copy(nameDuplicate = newDoCheckNameDuplicate)
    }

    // Check ID validation (dummy for now)
    fun checkIdValidation() {
        viewModelScope.launch {
            runCatching {
                adminAuthRepository.checkUsername(_state.value.userName)
                _state.value = _state.value.copy(nameDuplicate = true)
            }.onSuccess {
                _state.value = _state.value.copy(nameDuplicate = true)
                Log.d("AdminSignUpViewModel", "checkIdValidation : onSuccess")
            }.onFailure {
                _state.value = _state.value.copy(nameDuplicate = false)
                Log.d("AdminSignUpViewModel", "checkIdValidation : onFailure")
            }
        }
    }

    fun performHospitalSearch(query: String) {
        viewModelScope.launch {
            runCatching {
                adminAuthRepository.getHospitalList(searchText = query)
            }.onSuccess { response ->
                val hospitalList = response.result.toDomainModel().hospitals

                _state.value = _state.value.copy(hospitalList = hospitalList)
                Log.d("AdminSignUpViewModel", "loadHospitalList : onSuccess ${hospitalList}")

            }.onFailure {
                _state.update { currentState ->
                    currentState.copy(hospitalList = emptyList())
                }
                Log.d("AdminSignUpViewModel", "loadHospitalList : onFailure : ${it.message}")
            }
        }
    }

//    fun loadHospitalList(selectedHospitalList: String) {
//        viewModelScope.launch {
//            runCatching {
//                adminAuthRepository.getHospitalList("")
//            }.onSuccess { response ->
//                //_state.value = _state.value.copy(hospitalList = ) // copy 사용
//                val hospitals = response.result.hospitals.map{
//                    HospitalList.Hospital(it.id, it.name)
//                }
//                _state.update { currentState ->
//                    currentState.copy(hospitalList = hospitals)
//
//                }
//                Log.d("AdminSignUpViewModel", "loadDepartmentList : onSuccess ${hospitals}")
//            }.onFailure {
//                Log.d("AdminSignUpViewModel", "loadDepartmentList : onFailure : ${it.message}")
//            }
//        }
//    }

    fun loadDepartmentList(selectedHospitalId: String) {
        viewModelScope.launch {
            runCatching {
                adminAuthRepository.getAdminDepartmentList(selectedHospitalId)
            }.onSuccess {
                _state.value = _state.value.copy(departmentList = it.departments) // copy 사용
                Log.d("AdminSignUpViewModel", "loadDepartmentList : onSuccess ${it.departments}")
            }.onFailure {
                Log.d("AdminSignUpViewModel", "loadDepartmentList : onFailure : ${it.message}")
            }
        }
    }

    fun requestSignUp() {
        viewModelScope.launch {
            runCatching {
                adminAuthRepository.adminSignUp(
                    AdminUser(
                        name = _state.value.userName,
                        userId = _state.value.userId,
                        password = _state.value.password,
                        hospitalYkifo = _state.value.selectedHospitalykiho,
                        hospitalName = _state.value.selectedHospitalName,
                        departmentName = _state.value.selectedDepartmentName
                    )
                )
            }.onSuccess {
                _sideEffect.value = AdminSignUpHospitalEntrySideEffect.SignUpSuccess
                Log.d("AdminSignUpViewModel", "requestSignUp : onSuccess")
            }.onFailure {
                _sideEffect.value = AdminSignUpHospitalEntrySideEffect.ShowToast("회원가입에 실패했습니다.\n다시 시도해주세요.")
                Log.d("AdminSignUpViewModel", "requestSignUp : onFailure : ${it.message}")
            }
        }
    }
    fun updateSearchQuery(query: String){
        //_state.value = _state.value.copy(searchQuery = query)
        _state.update { it.copy(searchQuery = query) }
    }
}
