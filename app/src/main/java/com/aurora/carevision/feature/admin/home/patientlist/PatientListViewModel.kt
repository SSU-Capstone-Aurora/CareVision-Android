package com.aurora.carevision.feature.admin.home.patientlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.domain.admin.repository.AdminPatientListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PatientListViewModel @Inject constructor(
    private val adminPatientListRepository: AdminPatientListRepository
) : ViewModel(){

    private val _state: MutableStateFlow<PatientListState> = MutableStateFlow(PatientListState())
    val state :MutableStateFlow<PatientListState> = _state

    private val _sideEffect: MutableStateFlow<PatientListSideEffect?> = MutableStateFlow(null)
    val sideEffect : MutableStateFlow<PatientListSideEffect?> = _sideEffect

    fun getAdminPatientList(){
        viewModelScope.launch {
            runCatching {
                adminPatientListRepository.getAdminPatientList()
            }.onSuccess {
                _state.value = state.value.copy(patientList = it)
                Log.d("PatientListViewModel", "getAdminPatientList : ${it.size}")
                _sideEffect.value = PatientListSideEffect.GetPatientListSuccess
            }.onFailure {
                _sideEffect.value = PatientListSideEffect.GetPatientListFailure
            }
        }
    }
}