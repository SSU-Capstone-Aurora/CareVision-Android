package com.aurora.carevision.domain.nurse.model

data class Camera(
    val cameraCode: String,
    val inpatientWardNumber: Int,
    val patientRoomNumber: Int,
    val bedNumber: Int,
)
