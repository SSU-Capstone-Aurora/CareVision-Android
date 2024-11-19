package com.aurora.carevision.feature.admin.registration.camera

data class CameraRegistrationState(
    var cameraSerialNumber: String = "",
    val isTyping: Boolean = false,
    val isFieldVisible: Boolean = false,
    val wardNumber: Int,
    val bedNumber: Int,
    val roomNumber: Int,
    val isDigitError: Boolean = false,

)