package com.aurora.carevision.feature.admin.home.cameralist

import android.util.Log
import android.widget.MultiAutoCompleteTextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.domain.admin.repository.AdminCameraListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraListViewModel @Inject constructor(
    private val adminCameraListRepository: AdminCameraListRepository
): ViewModel() {

    private val _state: MutableStateFlow<CameraListState> = MutableStateFlow(CameraListState())
    val state : MutableStateFlow<CameraListState> = _state

    private val _sideEffect: MutableStateFlow<CameraListSideEffect?> = MutableStateFlow(null)
    val sideEffect : MutableStateFlow<CameraListSideEffect?> = _sideEffect

    fun getAdminCameraList(){
        viewModelScope.launch {
            runCatching {
                adminCameraListRepository.getAdminCameraList()
            }.onSuccess {
                _state.value = state.value.copy(cameraList = it)
                Log.d("CameraListViewModel", "getAdminCameraList : ${it.size}")
                _sideEffect.value = CameraListSideEffect.GetCameraListSuccess
            }.onFailure {
                _sideEffect.value = CameraListSideEffect.GetCameraListFailure
            }
        }
    }
}