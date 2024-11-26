package com.aurora.carevision.feature.admin.request

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.data.remote.admin.nurserequest.repository.DefaultAdminNurseRequestRepository
import com.aurora.carevision.domain.admin.repository.AdminAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
}

