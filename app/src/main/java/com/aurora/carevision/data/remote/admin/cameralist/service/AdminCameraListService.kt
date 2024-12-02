package com.aurora.carevision.data.remote.admin.cameralist.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.cameralist.model.AdminCameraListResponse
import retrofit2.http.GET

interface AdminCameraListService {
    @GET("api/admin/cameras")
    suspend fun getAdminCameraList(): BaseResponse<AdminCameraListResponse>
}