package com.aurora.carevision.feature.admin.registration.camera

data class CameraRegistrationState(
    var cameraSerialNumber: String = "",
    val isTyping: Boolean = false,
    val isFieldVisible: Boolean = false,
//    val wardNumber: Int? = null,
//    val bedNumber: Int? = null ,
//    val roomNumber: Int? = null,
    val wardNumber: String? = "",
    val bedNumber: String? = "",
    val roomNumber: String? = "",
    val isDigitError: Boolean = false,

)