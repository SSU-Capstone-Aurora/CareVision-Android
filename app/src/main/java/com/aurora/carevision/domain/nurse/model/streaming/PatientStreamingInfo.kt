package com.aurora.carevision.domain.nurse.model.streaming

data class PatientStreamingInfo(
    val patientId: Int,
    val patientName: String,
    val thumbnailImage: String,
    val inpatientWardNumber: Int,
    val patientRoomNumber: Int,
    val bedNumber: Int,
    val liveStreamingUrl: String,
    //val savedVideo: List<SavedVideo>,
)