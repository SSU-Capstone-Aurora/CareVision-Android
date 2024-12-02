package com.aurora.carevision.feature.admin.home.patientlist

sealed class PatientListSideEffect {
    object GetPatientListSuccess : PatientListSideEffect()
    object GetPatientListFailure : PatientListSideEffect()
}