package com.aurora.carevision.feature.admin.request

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.data.remote.admin.nurserequest.repository.DefaultAdminNurseRequestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminRequestAcceptanceViewModel @Inject constructor(
    private val adminNurseRequestRepository: DefaultAdminNurseRequestRepository
) : ViewModel() {

    val _state:MutableStateFlow<AdminRequestAcceptanceState> = MutableStateFlow(AdminRequestAcceptanceState())
    val state: StateFlow<AdminRequestAcceptanceState> = _state

    val _sideEffect: MutableStateFlow<AdminRequestAcceptanceSideEffect?> = MutableStateFlow(null)
    val sideEffect: MutableStateFlow<AdminRequestAcceptanceSideEffect?> = _sideEffect

    fun loadNurseRequests() {
        viewModelScope.launch {
            runCatching {
                adminNurseRequestRepository.getNurseRequests()
            }.onSuccess {
                _state.value = _state.value.copy(requestCount = it.requestCount)
                _state.value = _state.value.copy(requests = it.requests)
                Log.d("AdminRequestAcceptanceViewModel", "loadNurseRequestList : onSuccess ${it.requests}")
            }.onFailure {
                Log.d("AdminRequestAcceptanceViewModel", "loadNurseRequestList : onSuccess ${it.message}")
            }
        }
    }

    fun setSelectedNurseName(nurseName: String){
        _state.value = _state.value.copy(selectedNurseName = nurseName)
    }

    fun showDialog(nurseId : Int, nurseName: String){
        _state.update {
            it.copy(
                isDialogVisible = true,
                selectedNurseId = nurseId,
                selectedNurseName = nurseName,
            )
        }
    }

    fun dismissDialog(){
        _state.update {
            it.copy(
                isDialogVisible = false,
                selectedNurseId = 0
            )
        }
    }
    fun acceptNurseRequest(){
        val nurseId = state.value.selectedNurseId
        viewModelScope.launch {
            runCatching {
                adminNurseRequestRepository.acceptNurseRequests(nurseId)
            }.onSuccess {

                _sideEffect.emit(AdminRequestAcceptanceSideEffect.NavigateToNurseList)
                dismissDialog()
                loadNurseRequests()
                Log.d("AdminRequestAcceptanceViewModel", "SuccessAcceptNurse : onSuccess ${it}")
            }.onFailure {
                _sideEffect.value = AdminRequestAcceptanceSideEffect.Error(it.message)
                Log.d("AdminRequestAcceptanceViewModel", "FailAcceptNurse : onSuccess ${it.message}")
            }
        }
    }
}

