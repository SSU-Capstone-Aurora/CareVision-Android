package com.aurora.carevision.feature.nurse.patient.info

sealed class PatientInfoSideEffect {
    object GetMyPatientInfoListSuccess : PatientInfoSideEffect()
    object GetMyPatientInfoListFailure : PatientInfoSideEffect()
}