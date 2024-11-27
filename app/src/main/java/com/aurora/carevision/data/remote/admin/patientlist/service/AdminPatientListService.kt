package com.aurora.carevision.data.remote.admin.patientlist.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.patientlist.model.AdminPatientListResponse
import retrofit2.http.GET

interface AdminPatientListService {
    @GET("api/admin/patients")
    suspend fun getAdminPatientList(): BaseResponse<AdminPatientListResponse>
}