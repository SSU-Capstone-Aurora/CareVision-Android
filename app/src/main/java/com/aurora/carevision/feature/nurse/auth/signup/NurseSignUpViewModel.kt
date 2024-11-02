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
        Log.d("NurseSignUpViewModel", "updateSelectedHospital: ${_state.value.hospitalName}")
    }

    fun updateSelectedDepartment(newDepartment: String) {
        _state.value = _state.value.copy(department = newDepartment)
        Log.d("NurseSignUpViewModel", "updateSelectedDepartment: ${_state.value.department}")
    }
}