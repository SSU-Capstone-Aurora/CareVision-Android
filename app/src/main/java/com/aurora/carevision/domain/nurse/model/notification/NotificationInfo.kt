package com.aurora.carevision.domain.nurse.model.notification

data class Notification(
    val roomBedInfo: String,
    val notificationTime: String,
    val notificationContent: String,
    val isChecked: Boolean
)