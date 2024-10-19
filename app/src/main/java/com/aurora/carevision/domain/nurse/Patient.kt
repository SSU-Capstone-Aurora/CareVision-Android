package com.aurora.carevision.domain.nurse

data class Patient(
    val patientId: Int,
    val patientNum: String,
    val patientName: String,
    val patientRoom: String,
    val registrationDate: String,
)