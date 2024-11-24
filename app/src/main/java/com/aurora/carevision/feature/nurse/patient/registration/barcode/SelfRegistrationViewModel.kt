package com.aurora.carevision.feature.nurse.patient.registration.barcode

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SelfRegistrationViewModel @Inject constructor(

) : ViewModel(){

    private val _state: MutableStateFlow<SelfRegistrationState> = MutableStateFlow(SelfRegistrationState())
    val state: StateFlow<SelfRegistrationState> = _state

    private val _sideEffect: MutableStateFlow<SelfRegistrationSideEffect?> = MutableStateFlow(null)
    val sideEffect: StateFlow<SelfRegistrationSideEffect?> = _sideEffect

    fun updatePatientName(newPatientName: String){
        _state.value = _state.value.copy(patientName = newPatientName)
    }

    fun updatePatientScanBarcode(newPatientScanBarcode: String){
        _state.value = _state.value.copy(patientBarcodeNumber = newPatientScanBarcode)
        Log.d("SelfRegistrationViewModel", "updatedPatientScanBarcode : ${state.value.patientBarcodeNumber}")
    }

    fun updateScanBarcodeSuccess(newScanBarcodeSuccess: Boolean){
        _state.value = _state.value.copy(scanBarcodeSuccess = newScanBarcodeSuccess)
    }

}