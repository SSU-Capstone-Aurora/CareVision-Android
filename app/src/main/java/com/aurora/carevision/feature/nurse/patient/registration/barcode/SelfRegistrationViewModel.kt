package com.aurora.carevision.feature.nurse.patient.registration.barcode

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SelfRegistrationViewModel @Inject constructor(

) : ViewModel(){

    val state: MutableStateFlow<SelfRegistrationState> = MutableStateFlow(SelfRegistrationState())
    val _state: MutableStateFlow<SelfRegistrationState> = state

    val sideEffect: MutableStateFlow<SelfRegistrationSideEffect?> = MutableStateFlow(null)
    val _sideEffect: MutableStateFlow<SelfRegistrationSideEffect?> = sideEffect

    fun updatePatientName(newPatientName: String){
        state.value = state.value.copy(patientName = newPatientName)
    }

    fun updatePatientScanBarcode(newPatientScanBarcode: String){
        state.value = state.value.copy(patientBarcodeNumber = newPatientScanBarcode)
    }

    fun updateScanBarcodeSuccess(newScanBarcodeSuccess: Boolean){
        state.value = state.value.copy(scanBarcodeSuccess = newScanBarcodeSuccess)
    }

}