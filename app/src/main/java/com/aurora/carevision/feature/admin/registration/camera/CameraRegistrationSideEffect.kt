package com.aurora.carevision.feature.admin.registration.camera

sealed class CameraRegistrationSideEffect {
    object NavigateNextScreen :CameraRegistrationSideEffect()
    object ShowError : CameraRegistrationSideEffect()
    //data class PerformHospitalSearch(val query: String) : CameraRegistrationSideEffect()
    object NavigateToInfo : CameraRegistrationSideEffect()
    object NavigateToFinish : CameraRegistrationSideEffect()
    object NavigateToWaiting : CameraRegistrationSideEffect()
    object NavigateToHome : CameraRegistrationSideEffect()

}