package com.aurora.carevision.feature.admin.registration.patient

data class AdminPatientRegistrationState(
    val isTyping: Boolean = false,
    val isFieldVisible: Boolean = false,
    val patientInfo: String? = "",
    val patientName: String? = "",
    val cameraSerialNum: String? = "",
    val cameraWardNum: String? = "",
    val cameraBedNum: String? = "",
    val cameraRoomNum: String? = "",
    )