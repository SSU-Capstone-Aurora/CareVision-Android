package com.aurora.carevision.feature.admin.registration.patient

sealed class AdminPatientRegistrationSideEffect {
    object ShowError : AdminPatientRegistrationSideEffect()
    object NavigateToPatientNumInfo : AdminPatientRegistrationSideEffect()
    object NavigateToCheckName : AdminPatientRegistrationSideEffect()
    object NavigateToCameraInfo : AdminPatientRegistrationSideEffect()
    object NavigateToCheckFinalInfo : AdminPatientRegistrationSideEffect()
    object NavigateToBack : AdminPatientRegistrationSideEffect()
}
