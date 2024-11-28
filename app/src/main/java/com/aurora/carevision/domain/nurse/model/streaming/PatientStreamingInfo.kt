package com.aurora.carevision.domain.nurse.model.streaming

data class PatientStreamingInfo(
    val patientId: Int,
    val patientName: String,
    val thumbnailImage: String,
    val bedInfo: List<BedInfo>,
    //val savedVideo: List<SavedVideo>,
){
    data class BedInfo(
        val inpatientWardNumber: Int,
        val patientRoomNumber: Int,
        val bedNumber: Int,
    )
}