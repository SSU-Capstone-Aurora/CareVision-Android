package com.aurora.carevision.feature.nurse.patient.registration.barcode

data class SelfRegistrationState(
    val patientName: String = "",
    val patientId: String = "",
    val patientBarcodeNumber: String = "",
    val scanBarcodeSuccess: Boolean = false,
    val isRegistrationSuccess: Boolean = false,

)