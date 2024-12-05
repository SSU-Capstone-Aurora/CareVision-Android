package com.aurora.carevision.feature.admin.home.nurselist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.domain.admin.repository.AdminNurseListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NurseListScreenViewModel @Inject constructor(
    private val nurseListRepository: AdminNurseListRepository
) : ViewModel() {

    val _state: MutableStateFlow<NurseListScreenState> = MutableStateFlow(NurseListScreenState())
    val state: StateFlow<NurseListScreenState> = _state

    val _sideEffect: MutableStateFlow<NurseListScreenSideEffect?> = MutableStateFlow(null)
    val sideEffect: MutableStateFlow<NurseListScreenSideEffect?> = _sideEffect

    fun loadNurseList() {
        viewModelScope.launch {
            runCatching {
                nurseListRepository.getNurseList()
            }.onSuccess {
                _state.value = state.value.copy(nurses = it)
                Log.d("NurseListViewModel", "getNurseList : ${it.size}")
                _sideEffect.value = NurseListScreenSideEffect.GetNurseListSuccess
            }.onFailure {
                _sideEffect.value = NurseListScreenSideEffect.GetNurseListFailure
            }
        }
    }
}