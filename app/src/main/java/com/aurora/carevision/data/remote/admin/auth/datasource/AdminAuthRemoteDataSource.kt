package com.aurora.carevision.data.remote.admin.auth.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminDepartmentListResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminHospitalListResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminLoginResponse
import com.aurora.carevision.data.remote.admin.nurserequest.model.AdminNurseRequestResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminSignUpResponse
import com.aurora.carevision.data.remote.admin.auth.model.request.AdminLoginRequest
import com.aurora.carevision.data.remote.admin.auth.model.request.AdminSignUpRequest


interface AdminAuthRemoteDataSource {

    suspend fun checkUsername(username: String): Boolean
    suspend fun getAdminHospitalList(searchText: String): BaseResponse<AdminHospitalListResponse>
    suspend fun getAdminDepartmentList(hospitalId: String): BaseResponse<AdminDepartmentListResponse>
    suspend fun adminSignUp(adminSignUpRequest: AdminSignUpRequest): BaseResponse<AdminSignUpResponse>
    suspend fun adminLogin(adminLoginRequest: AdminLoginRequest): BaseResponse<AdminLoginResponse>

}
