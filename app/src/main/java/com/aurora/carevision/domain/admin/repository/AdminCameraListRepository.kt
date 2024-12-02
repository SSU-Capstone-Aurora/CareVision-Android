package com.aurora.carevision.domain.admin.repository

import com.aurora.carevision.domain.admin.model.camera.Camera

interface AdminCameraListRepository {
    suspend fun getAdminCameraList(): List<Camera>
}