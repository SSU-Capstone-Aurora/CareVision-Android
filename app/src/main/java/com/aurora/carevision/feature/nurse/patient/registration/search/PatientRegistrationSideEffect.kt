package com.aurora.carevision.feature.nurse.patient.registration.search

sealed class PatientRegistrationSideEffect {
    object GetPatientListSuccess : PatientRegistrationSideEffect()
    object GetPatientListFailure : PatientRegistrationSideEffect()
    object PostNewPatientSuccess : PatientRegistrationSideEffect()
    object PostNewPatientFailure : PatientRegistrationSideEffect()
    object PostAlreadyPatientSuccess : PatientRegistrationSideEffect()
    object PostAlreadyPatientFailure : PatientRegistrationSideEffect()
}