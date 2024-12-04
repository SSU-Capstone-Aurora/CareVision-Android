package com.aurora.carevision.feature.nurse.home.home

import com.aurora.carevision.domain.nurse.model.streaming.PatientStreamingInfo

data class HomeState(
    val patientStreamingList: List<PatientStreamingInfo> = emptyList(),
    val clickedPatientInfo: PatientStreamingInfo? = null
)