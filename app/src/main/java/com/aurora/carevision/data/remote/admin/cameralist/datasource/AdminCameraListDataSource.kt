package com.aurora.carevision.data.remote.admin.cameralist.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.cameralist.model.AdminCameraListResponse

interface AdminCameraListDataSource {
    suspend fun getAdminCameraList(): BaseResponse<AdminCameraListResponse>
}