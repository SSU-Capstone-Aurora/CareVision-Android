package com.aurora.carevision.domain.admin.model.patient

data class Patient(
    val patientName: String,
    val inpatientWardNumber: Int,
    val patientRoom: Int,
    val bedNumber: Int,
    val code: String,
)