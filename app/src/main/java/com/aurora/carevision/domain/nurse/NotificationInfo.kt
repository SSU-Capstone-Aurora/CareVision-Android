package com.aurora.carevision.domain.nurse

data class Notification(
    val roomBedInfo: String,
    val notificationTime: String,
    val notificationContent: String,
    val isChecked: Boolean
)