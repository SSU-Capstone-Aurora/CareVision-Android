package com.aurora.carevision.data.remote.admin.cameralist.repository

import com.aurora.carevision.domain.admin.repository.AdminCameraListRepository
import com.aurora.carevision.data.remote.admin.cameralist.datasource.AdminCameraListDataSource
import com.aurora.carevision.data.remote.admin.cameralist.model.toDomainModel
import com.aurora.carevision.domain.admin.model.camera.Camera
import javax.inject.Inject

class DefaultAdminCameraListRepository @Inject constructor(
    private val adminCameraListDataSource: AdminCameraListDataSource
): AdminCameraListRepository{
    override suspend fun getAdminCameraList(): List<Camera>{
        return adminCameraListDataSource.getAdminCameraList().result.toDomainModel()
    }
}