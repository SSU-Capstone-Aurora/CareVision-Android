package com.aurora.carevision.domain.nurse.model

data class Patient(
    val patientId: Int = -1,
    val patientCode: String,
    val patientName: String,
    val registrationDate: String = "",
    val patientRoom: Int,
    val inpatientWardNumber: Int,
    val bedNumber: Int,
    val cameraId: String = "",
)