package com.aurora.carevision.data.remote.admin.patientlist.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.patientlist.model.AdminPatientListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AdminPatientListService {
    @GET("api/admin/patients")
    suspend fun getAdminPatientList(
        @Query("size") size: Int,
        @Query("lastIdx") lastIdx: Int
    ): BaseResponse<AdminPatientListResponse>
}