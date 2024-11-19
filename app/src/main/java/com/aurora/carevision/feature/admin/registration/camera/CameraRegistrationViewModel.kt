package com.aurora.carevision.feature.admin.registration.camera

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
class CameraRegistrationViewModel @Inject constructor(

) : ViewModel() {
    val _state: MutableStateFlow<CameraRegistrationState> = MutableStateFlow(CameraRegistrationState())
    val state: StateFlow<CameraRegistrationState> = _state


    val _sideEffect: MutableSharedFlow<CameraRegistrationSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<CameraRegistrationSideEffect> = _sideEffect

    fun updateSerialNumber(newcameraSerialNumber: String) {
        _state.value = _state.value.copy(cameraSerialNumber = newcameraSerialNumber)
    }

    fun updateWardNumber(newWardNumber: String) {
        _state.value = _state.value.copy(wardNumber = newWardNumber)
    }

    fun updateRoomNumber(newRoomNumber: String) {
        _state.value = _state.value.copy(roomNumber = newRoomNumber)
    }

    fun updateBedNumber(newBedNumber: String) {
        _state.value = _state.value.copy(bedNumber = newBedNumber)
    }
    fun validateDigitField(input: String): Boolean {
        val isValid = input.all { it.isDigit() }
        _state.update { it.copy(isDigitError = !isValid) }
        return isValid
    }

    fun submitToServer() {}
}