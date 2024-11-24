package com.aurora.carevision.data.remote.admin.auth.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminDepartmentListResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminHospitalListResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminSignUpResponse
import com.aurora.carevision.data.remote.admin.auth.model.request.AdminSignUpRequest
import com.aurora.carevision.data.remote.admin.auth.service.AdminAuthService

import javax.inject.Inject

class DefaultAdminAuthDataSource @Inject constructor(
    private val adminAuthService: AdminAuthService
) : AdminAuthRemoteDataSource {
    override suspend fun checkUsername(username: String): Boolean {
        return adminAuthService.checkDuplicationAdmin(username).result
    }

    override suspend fun getAdminHospitalList(searchText: String): BaseResponse<AdminHospitalListResponse> {
        return adminAuthService.getAdminHospitalList(searchText)
    }

    override suspend fun getAdminDepartmentList(hospitalId: String): BaseResponse<AdminDepartmentListResponse> {
        return adminAuthService.getAdminDepartmentList(hospitalId)
    }

    override suspend fun adminSignUp(adminSignUpRequest: AdminSignUpRequest): BaseResponse<AdminSignUpResponse> {
        return adminAuthService.adminSignUp(adminSignUpRequest)
    }
}

