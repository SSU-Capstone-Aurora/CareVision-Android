package com.aurora.carevision.feature.admin.registration.patient

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName
import javax.inject.Inject

@HiltViewModel
class AdminPatientRegistrationViewModel @Inject constructor(

) : ViewModel() {
    val _state: MutableStateFlow<AdminPatientRegistrationState> = MutableStateFlow(
        AdminPatientRegistrationState()
    )
    val state: StateFlow<AdminPatientRegistrationState> = _state


    val _sideEffect: MutableSharedFlow<AdminPatientRegistrationSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<AdminPatientRegistrationSideEffect> = _sideEffect

    fun updatePatientName(newPatientName: String) {
        _state.value = _state.value.copy(patientName = newPatientName)
    }
    fun updatePatientInfo(newPatientInfo: String) {
        _state.value = _state.value.copy(patientInfo = newPatientInfo)
    }

    fun updateCameraWardNumber(newCameraWardNumber: String) {
        _state.value = _state.value.copy(cameraWardNum = newCameraWardNumber)
    }

    fun updateCameraRoomNumber(newCameraRoomNumber: String) {
        _state.value = _state.value.copy(cameraRoomNum = newCameraRoomNumber)
    }

    fun updateCameraBedNumber(newCameraBedNumber: String) {
        _state.value = _state.value.copy(cameraBedNum = newCameraBedNumber)
    }

    fun submitToServer() {}
}