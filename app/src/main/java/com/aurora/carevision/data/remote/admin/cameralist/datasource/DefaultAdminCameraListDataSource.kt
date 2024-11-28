package com.aurora.carevision.data.remote.admin.cameralist.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.cameralist.model.AdminCameraListResponse
import com.aurora.carevision.data.remote.admin.cameralist.service.AdminCameraListService
import javax.inject.Inject

class DefaultAdminCameraListDataSource @Inject constructor(
    private val adminCameraListService: AdminCameraListService
): AdminCameraListDataSource{
    override suspend fun getAdminCameraList(): BaseResponse<AdminCameraListResponse> {
        return adminCameraListService.getAdminCameraList()
    }
}
