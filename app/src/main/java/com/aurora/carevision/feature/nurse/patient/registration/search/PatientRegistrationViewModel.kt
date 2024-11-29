package com.aurora.carevision.feature.nurse.patient.registration.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
}