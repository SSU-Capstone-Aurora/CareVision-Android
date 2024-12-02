package com.aurora.carevision.feature.nurse.patient.info

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.domain.nurse.repository.NursePatientInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientInfoViewModel @Inject constructor(
    private val nursePatientInfoRepository: NursePatientInfoRepository
): ViewModel(){

    private val _state: MutableStateFlow<PatientInfoState> = MutableStateFlow(PatientInfoState())
    val state :MutableStateFlow<PatientInfoState> = _state

    private val _sideEffect: MutableStateFlow<PatientInfoSideEffect?> = MutableStateFlow(null)
    val sideEffect: MutableStateFlow<PatientInfoSideEffect?> = _sideEffect

    fun getPatientList(){
        viewModelScope.launch {
            runCatching {
                nursePatientInfoRepository.getPatientList()
            }.onSuccess {
                _state.value = state.value.copy(patientInfoList = it)
                Log.d("PatientInfoViewModel", "getPatientList: ${it.size}")
                _sideEffect.value = PatientInfoSideEffect.GetMyPatientInfoListSuccess
            }.onFailure {
                _sideEffect.value = PatientInfoSideEffect.GetMyPatientInfoListFailure
            }
        }
    }
}