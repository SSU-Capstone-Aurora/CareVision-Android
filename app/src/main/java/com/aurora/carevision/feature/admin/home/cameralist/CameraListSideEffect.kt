package com.aurora.carevision.feature.admin.home.cameralist

sealed class CameraListSideEffect {
    object GetCameraListSuccess : CameraListSideEffect()
    object GetCameraListFailure : CameraListSideEffect()
}