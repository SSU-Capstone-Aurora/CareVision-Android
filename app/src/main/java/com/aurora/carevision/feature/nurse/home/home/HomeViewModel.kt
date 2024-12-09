package com.aurora.carevision.feature.nurse.home.home

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aurora.carevision.data.local.auth.TokenProvider
import com.aurora.carevision.data.remote.nurse.fcm.model.FCMRequestBody
import com.aurora.carevision.data.remote.nurse.fcm.service.FirebaseTokenService
import com.aurora.carevision.domain.nurse.model.streaming.PatientStreamingInfo
import com.aurora.carevision.domain.nurse.repository.NurseMypageRepository
import com.aurora.carevision.domain.nurse.repository.PatientStreamingRepository
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val patientStreamingRepository: PatientStreamingRepository,
    private val mypageRepository: NurseMypageRepository,
    private val tokenProvider: TokenProvider,
) : ViewModel() {
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val state: MutableStateFlow<HomeState> = _state

    private val _sideEffect: MutableStateFlow<HomeSideEffect?> = MutableStateFlow(null)
    val sideEffect: MutableStateFlow<HomeSideEffect?> = _sideEffect

    fun updateClickedPatientInfo(patientInfo: PatientStreamingInfo) {
        _state.value = state.value.copy(
            clickedPatientInfo = patientInfo,
            clickedPatientId = patientInfo.patientId
        )
    }

    fun updateClickedSavedVideoInfo(videoId: Int, clickedSavedVideoDate: String) {
        _state.value = state.value.copy(
            clickedSavedVideoId = videoId,
            clickedSavedVideoDate = clickedSavedVideoDate
        )
    }

    fun updateClickedPatientId(patientId: Int) {
        _state.value = state.value.copy(clickedPatientId = patientId)
    }

    fun getNurseMypageInfo() {
        viewModelScope.launch {
            runCatching {
                mypageRepository.getNurseMypage()
            }.onSuccess {
                _state.value = _state.value.copy(
                    nurseName = it.name,
                )
                tokenProvider.saveUserName(it.name)
                _sideEffect.value = HomeSideEffect.GetNurseMypageSuccess
                Log.d("NurseMypage", "${state.value.nurseName}")
            }.onFailure {
                _sideEffect.value = HomeSideEffect.GetNurseMypageFailure
            }
        }
    }

    fun getPatientStreamingList() {
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

    fun getSpecifyPatientStreamingUri(patientId: Int) {
        viewModelScope.launch {
            runCatching {
                patientStreamingRepository.getSpecifyPatientStreamingUri(patientId)
            }.onSuccess {
                _state.value = state.value.copy(
                    liveStreamingPatientName = it.patientName,
                    liveStreamingRtspUrl = it.liveStreamingUrl,
                    liveStreamingPatientInpatientWardNumber = it.inpatientWardNumber,
                    liveStreamingPatientRoomNumber = it.patientRoomNumber,
                    liveStreamingPatientBedNumber = it.bedNumber
                )
                _sideEffect.value = HomeSideEffect.GetSpecifyPatientStreamingUriSuccess
                Log.d("HomeViewModel", "getSpecifyPatientStreamingUri: ${it}")
            }.onFailure {
                _sideEffect.value = HomeSideEffect.GetSpecifyPatientStreamingUriFailure
                Log.d("HomeViewModel", "getSpecifyPatientStreamingUri: ${it}")
            }
        }
    }

    fun getSavedVideos(patientId: Int) {
        viewModelScope.launch {
            runCatching {
                patientStreamingRepository.getSavedVideos(patientId)
            }.onSuccess {
                _state.value = state.value.copy(savedVideoList = it)
                _sideEffect.value = HomeSideEffect.GetSavedVideosSuccess
                Log.d("HomeViewModel", "getSavedVideos: ${it}")
            }.onFailure {
                _sideEffect.value = HomeSideEffect.GetSavedVideosFailure
                Log.d("HomeViewModel", "getSavedVideos: ${it}")
            }
        }
    }

    fun getSpecifyPatientSavedVideoUri(videoId: Int) {
        viewModelScope.launch {
            runCatching {
                patientStreamingRepository.getVideoUri(videoId)
            }.onSuccess {
                _state.value = state.value.copy(specifyPatientSavedVideoUri = it)
                _sideEffect.value = HomeSideEffect.GetSpecifyPatientSavedVideoUriSuccess
                Log.d("HomeViewModel", "getSpecifyPatientSavedVideoUri: ${it}")
            }.onFailure {
                _sideEffect.value = HomeSideEffect.GetSpecifyPatientSavedVideoUriFailure
                Log.d("HomeViewModel", "getSpecifyPatientSavedVideoUri: ${it}")
            }
        }
    }

    fun getNotificationList() {
        viewModelScope.launch {
            runCatching {
                patientStreamingRepository.getNotificationList()
            }.onSuccess {
                _state.value = state.value.copy(
                    notificationList = it,
                )
                _sideEffect.value = HomeSideEffect.GetNotificationListSuccess
                Log.d("HomeViewModel", "getNotificationList: ${it}")
            }.onFailure {
                _sideEffect.value = HomeSideEffect.GetNotificationListFailure
                Log.d("HomeViewModel", "getNotificationList: ${it}")
            }
        }
    }
}