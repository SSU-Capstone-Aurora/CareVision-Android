package com.aurora.carevision.feature.nurse.patient.registration.barcode

sealed class SelfRegistrationSideEffect{
    object GetPatientNameSuccess: SelfRegistrationSideEffect()
    object GetPatientNameFailure: SelfRegistrationSideEffect()
    object GetUnlinkedCamerasSuccess: SelfRegistrationSideEffect()
    object GetUnlinkedCamerasFailure: SelfRegistrationSideEffect()
    object PostNewPatientSuccess: SelfRegistrationSideEffect()
    object PostNewPatientFailure: SelfRegistrationSideEffect()

}