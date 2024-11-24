package com.aurora.carevision.data.remote.admin.auth.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminDepartmentListResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminHospitalListResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminSignUpResponse
import com.aurora.carevision.data.remote.admin.auth.model.request.AdminSignUpRequest
import com.aurora.carevision.data.remote.admin.auth.service.AdminAuthService


interface AdminAuthRemoteDataSource {

    suspend fun checkUsername(username: String): Boolean
    suspend fun getAdminHospitalList(searchText: String): BaseResponse<AdminHospitalListResponse>
    suspend fun getAdminDepartmentList(hospitalId: Int): BaseResponse<AdminDepartmentListResponse>
    suspend fun adminSignUp(adminSignUpRequest: AdminSignUpRequest): BaseResponse<AdminSignUpResponse>

}
