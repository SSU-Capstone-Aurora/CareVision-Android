package com.aurora.carevision.feature.nurse.home.home

import com.aurora.carevision.domain.nurse.model.notification.Notification
import com.aurora.carevision.domain.nurse.model.streaming.PatientStreamingInfo
import com.aurora.carevision.domain.nurse.model.streaming.SavedVideoInfo

data class HomeState(
    // 로그인한 간호사 정보
    val nurseName: String = "",
    val registeredAt: String? = "",
    val hospitalName: String = "",
    val department: String = "",

    val patientStreamingList: List<PatientStreamingInfo> = emptyList(),

    val clickedPatientInfo: PatientStreamingInfo? = null,
    val clickedPatientId: Int = -1,

    val liveStreamingPatientName : String = "",
    val liveStreamingRtspUrl : String = "",
    val liveStreamingPatientInpatientWardNumber : Int = 0,
    val liveStreamingPatientRoomNumber : Int = 0,
    val liveStreamingPatientBedNumber : Int = 0,

    val savedVideoList: List<SavedVideoInfo> = emptyList(),
    val specifyPatientSavedVideoUri: String = "",
    val clickedSavedVideoId: Int = 0,
    val clickedSavedVideoDate: String = "",

    // notification
    val notificationClickedPatientName: String = "",
    val notificationList: List<Notification> = emptyList(),

)