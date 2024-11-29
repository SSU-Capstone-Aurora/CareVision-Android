package com.aurora.carevision.feature.nurse.patient.registration.barcode

import com.aurora.carevision.domain.nurse.model.Camera

data class SelfRegistrationState(
    val patientName: String = "",
    val patientId: String = "",
    val patientBarcodeNumber: String = "",
    val patientNameValidation: Boolean = false,
    val scanBarcodeSuccess: Boolean = false,
    val isRegistrationSuccess: Boolean = false,
    val enabledNextButton: Boolean = false,

    val cameraList: List<Camera> = emptyList(),
    val selectedCameraCode: String = "",
    val selectedInpatientWardNumber: Int = 0,
    val selectedPatientRoomNumber: Int = 0,
    val selectedBedNumber: Int = 0,
)