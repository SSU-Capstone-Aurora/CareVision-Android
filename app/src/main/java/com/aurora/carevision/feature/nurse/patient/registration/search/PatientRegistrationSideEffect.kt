package com.aurora.carevision.feature.nurse.patient.registration.search

sealed class PatientRegistrationSideEffect {
    object GetPatientListSuccess : PatientRegistrationSideEffect()
    object GetPatientListFailure : PatientRegistrationSideEffect()
}