package com.aurora.carevision.feature.nurse.home.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.domain.nurse.repository.PatientStreamingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val patientStreamingRepository: PatientStreamingRepository
): ViewModel(){
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val state : MutableStateFlow<HomeState> = _state

    private val _sideEffect: MutableStateFlow<HomeSideEffect?> = MutableStateFlow(null)
    val sideEffect: MutableStateFlow<HomeSideEffect?> = _sideEffect

    fun getPatientStreamingList(){
        viewModelScope.launch {
            runCatching {
                patientStreamingRepository.getPatientVideoList()
            }.onSuccess {
                _state.value = state.value.copy(patientStreamingList = it)
                _sideEffect.value = HomeSideEffect.GetPatientStreamingListSuccess
                Log.d("HomeViewModel", "getPatientStreamingList: ${it}")
            }.onFailure {
                _sideEffect.value = HomeSideEffect.GetPatientStreamingListFailure
                Log.d("HomeViewModel", "getPatientStreamingList: ${it}")
            }
        }
    }

}