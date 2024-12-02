package com.aurora.carevision.feature.admin.home.cameralist

import com.aurora.carevision.domain.admin.model.camera.Camera

data class CameraListState (
    val cameraList: List<Camera> = emptyList()
)