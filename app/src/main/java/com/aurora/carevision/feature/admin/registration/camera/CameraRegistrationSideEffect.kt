package com.aurora.carevision.feature.admin.registration.camera

sealed class CameraRegistrationSideEffect {
    object NavigatetoHome :CameraRegistrationSideEffect()
    object ShowError : CameraRegistrationSideEffect()
    object NavigateToInfo : CameraRegistrationSideEffect()
    object NavigateToFinish : CameraRegistrationSideEffect()
    object NavigateToWaiting : CameraRegistrationSideEffect()
    object NavigateToBack : CameraRegistrationSideEffect()

}