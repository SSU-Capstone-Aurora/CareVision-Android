package com.aurora.carevision.feature.nurse.home.home

import com.aurora.carevision.domain.nurse.model.streaming.PatientStreamingInfo

data class HomeState(
    val patientStreamingList: List<PatientStreamingInfo> = emptyList(),
    val clickedPatientInfo: PatientStreamingInfo? = null,
    val liveStreamingPatientName : String = "",
    val liveStreamingRtspUrl : String = "",
    val liveStreamingPatientInpatientWardNumber : Int = 0,
    val liveStreamingPatientRoomNumber : Int = 0,
    val liveStreamingPatientBedNumber : Int = 0,
)