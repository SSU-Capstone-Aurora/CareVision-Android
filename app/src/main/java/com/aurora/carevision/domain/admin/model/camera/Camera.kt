package com.aurora.carevision.domain.admin.model.camera

data class Camera (
    val cameraId: String,
    val inpatientWardNumber: Int,
    val patientRoomNumber: Int,
    val bedNumber: Int,
)
