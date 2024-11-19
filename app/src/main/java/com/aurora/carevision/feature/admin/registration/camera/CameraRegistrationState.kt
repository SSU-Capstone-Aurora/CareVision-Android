package com.aurora.carevision.feature.admin.registration.camera

data class CameraRegistrationState(
    var cameraSerialNumber: String = "",
    val isTyping: Boolean = false,
    val isFieldVisible: Boolean = false,
    val wardNumber: Int,
    val bedNumber: Int,

    //20211119
    val isError: Boolean = false,
    val department: String = "",
    val userName: String = "",
    val userId: String = "",
    val password: String = "",
    val nameDuplicate: Boolean = false,
    val isHospitalSelected: Boolean = false,
)