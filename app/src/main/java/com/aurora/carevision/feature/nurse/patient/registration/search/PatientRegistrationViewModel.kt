package com.aurora.carevision.feature.nurse.patient.registration.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.domain.nurse.model.Patient
import com.aurora.carevision.domain.nurse.repository.NursePatientRegistrationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientRegistrationViewModel @Inject constructor(
    private val patientRegistrationRepository: NursePatientRegistrationRepository
): ViewModel() {

    private val _state: MutableStateFlow<PatientRegistrationState> = MutableStateFlow(PatientRegistrationState())
    val state: MutableStateFlow<PatientRegistrationState> = _state

    private val _sideEffect: MutableStateFlow<PatientRegistrationSideEffect?> = MutableStateFlow(null)
    val sideEffect: MutableStateFlow<PatientRegistrationSideEffect?> = _sideEffect

    fun updateSelectedPatient(patient: Patient){
        _state.value = _state.value.copy(selectedPatient = patient)
    }

    fun getPatientList(){
        viewModelScope.launch {
            runCatching {
                patientRegistrationRepository.getUnlinkedPatients()
            }.onSuccess {
                _state.value = _state.value.copy(patientList = it)
                _sideEffect.value = PatientRegistrationSideEffect.GetPatientListSuccess
            }.onFailure {
                _sideEffect.value = PatientRegistrationSideEffect.GetPatientListFailure
            }
        }
    }

    fun postNewPatient(patient: Patient){
        viewModelScope.launch {
            runCatching {
                patientRegistrationRepository.postNewPatient(patient)
            }.onSuccess {
                _sideEffect.value = PatientRegistrationSideEffect.PostNewPatientSuccess
            }.onFailure {
                _sideEffect.value = PatientRegistrationSideEffect.PostNewPatientFailure
            }
        }
    }

    fun postAlreadyPatient(){
        Log.d("PatientRegistrationViewModel", "postAlreadyPatient: ${_state.value.selectedPatient?.patientId}")
        viewModelScope.launch {
            runCatching {
                patientRegistrationRepository.postAlreadyPatient(_state.value.selectedPatient?.patientId ?: 0)
            }.onSuccess {
                _sideEffect.value = PatientRegistrationSideEffect.PostAlreadyPatientSuccess
            }.onFailure {
                _sideEffect.value = PatientRegistrationSideEffect.PostAlreadyPatientFailure
            }
        }
    }
}