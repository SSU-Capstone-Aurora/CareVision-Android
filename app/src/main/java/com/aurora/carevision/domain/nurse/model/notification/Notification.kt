package com.aurora.carevision.domain.nurse.model.notification

data class Notification(
    val documentId: String,
    val patientId: Int,
    val patientName: String,
    val inpatientWardNumber: Int,
    val patientRoomNumber: Int,
    val bedNumber: Int,
    val notificationTime: String,
    val isChecked: Boolean = false
)