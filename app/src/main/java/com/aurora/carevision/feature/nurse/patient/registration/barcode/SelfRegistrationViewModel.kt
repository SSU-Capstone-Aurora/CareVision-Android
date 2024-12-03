package com.aurora.carevision.feature.nurse.patient.registration.barcode

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.data.remote.nurse.registration.repository.DefalutNursePatientRegistrationRepository
import com.aurora.carevision.domain.nurse.model.Patient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelfRegistrationViewModel @Inject constructor(
    private val nursePatientRegistrationRepository: DefalutNursePatientRegistrationRepository
) : ViewModel(){

    private val _state: MutableStateFlow<SelfRegistrationState> = MutableStateFlow(SelfRegistrationState())
    val state: StateFlow<SelfRegistrationState> = _state

    private val _sideEffect: MutableStateFlow<SelfRegistrationSideEffect?> = MutableStateFlow(null)
    val sideEffect: StateFlow<SelfRegistrationSideEffect?> = _sideEffect

    fun updatePatientName(newPatientName: String){
        _state.value = _state.value.copy(patientName = newPatientName)
    }

    fun selectedCameraInfo(cameraCode: String, inpatientWardNumber: Int, patientRoomNumber: Int, bedNumber: Int){
        _state.value = _state.value.copy(
            selectedCameraCode = cameraCode,
            selectedInpatientWardNumber = inpatientWardNumber,
            selectedPatientRoomNumber = patientRoomNumber,
            selectedBedNumber = bedNumber
        )
    }

    fun updatePatientScanBarcode(newPatientScanBarcode: String){
        _state.value = _state.value.copy(patientBarcodeNumber = newPatientScanBarcode)
        Log.d("SelfRegistrationViewModel", "updatedPatientScanBarcode : ${state.value.patientBarcodeNumber}")
    }

    fun updateScanBarcodeSuccess(newScanBarcodeSuccess: Boolean){
        _state.value = _state.value.copy(scanBarcodeSuccess = newScanBarcodeSuccess)
    }

    fun getCheckPatientName(){
        viewModelScope.launch {
            runCatching {
                nursePatientRegistrationRepository.getRegistrationPatientName(_state.value.patientBarcodeNumber)
            }.onSuccess {
                _state.value = _state.value.copy(patientName = it, patientNameValidation = true, enabledNextButton = true)
                _sideEffect.value = SelfRegistrationSideEffect.GetPatientNameSuccess
            }.onFailure {
                _state.value = _state.value.copy(patientNameValidation = false, enabledNextButton = false)
                _sideEffect.value = SelfRegistrationSideEffect.GetPatientNameFailure
            }
        }
    }

    fun getUnlinkedCameras(){
        viewModelScope.launch {
            runCatching {
                nursePatientRegistrationRepository.getUnlinkedCameras()
            }.onSuccess {
                _state.value = _state.value.copy(cameraList = it)
                _sideEffect.value = SelfRegistrationSideEffect.GetUnlinkedCamerasSuccess
            }.onFailure {
                _sideEffect.value = SelfRegistrationSideEffect.GetUnlinkedCamerasFailure
            }
        }
    }

    fun postNewPatient(){
        viewModelScope.launch {
            runCatching {
                nursePatientRegistrationRepository.postNewPatient(
                    Patient(
                        patientName = state.value.patientName,
                        patientCode = state.value.patientBarcodeNumber,
                        inpatientWardNumber = state.value.selectedInpatientWardNumber,
                        patientRoom = state.value.selectedPatientRoomNumber,
                        bedNumber = state.value.selectedBedNumber,
                        cameraId = state.value.selectedCameraCode
                    )
                )
            }.onSuccess {
                _sideEffect.value = SelfRegistrationSideEffect.PostNewPatientSuccess
            }.onFailure {
                _sideEffect.value = SelfRegistrationSideEffect.PostNewPatientFailure
                Log.d("SelfRegistrationViewModel", "${it.message}")
            }
        }
    }
}