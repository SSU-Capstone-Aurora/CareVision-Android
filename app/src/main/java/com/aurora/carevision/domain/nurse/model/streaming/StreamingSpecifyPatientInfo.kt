package com.aurora.carevision.domain.nurse.model.streaming

data class StreamingSpecifyPatientInfo(
    val patientName: String,
    val inpatientWardNumber: Int,
    val patientRoomNumber: Int,
    val bedNumber: Int,
    val liveStreamingUrl: String,
)