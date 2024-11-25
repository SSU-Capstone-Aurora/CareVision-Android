package com.aurora.carevision.feature.nurse.mypage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.domain.nurse.repository.NurseMypageRepository
import com.aurora.carevision.feature.nurse.auth.signup.NurseSignUpSideEffect
import com.aurora.carevision.feature.nurse.auth.signup.NurseSignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MypageViewModel @Inject constructor(
    private val mypageRepository: NurseMypageRepository
): ViewModel(){

    private val _state: MutableStateFlow<NurseMypageState> = MutableStateFlow(NurseMypageState())
    val state : MutableStateFlow<NurseMypageState> = _state

    private val _sideEffect: MutableStateFlow<NurseMypageSideEffect?> = MutableStateFlow(null)
    val sideEffect: MutableStateFlow<NurseMypageSideEffect?> = _sideEffect

    init {
        getNurseMypageInfo()
    }

    fun getNurseMypageInfo(){
        viewModelScope.launch {
            runCatching {
                mypageRepository.getNurseMypage()
            }.onSuccess {
                _state.value = _state.value.copy(
                    nurseName = it.name,
                    hospitalName = it.hospitalName,
                    department = it.department,
                )
                _sideEffect.value = NurseMypageSideEffect.GetNurseMypageSuccess
                Log.d("NurseMypage", "${state.value.nurseName}")
            }.onFailure {
                _sideEffect.value = NurseMypageSideEffect.GetNurseMypageFailure
            }
        }
    }

}