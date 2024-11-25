package com.aurora.carevision.domain.admin.repository

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminDepartmentListResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminHospitalListResponse
import com.aurora.carevision.data.remote.admin.auth.model.request.AdminLoginRequest
import com.aurora.carevision.domain.admin.model.auth.AdminUser
import com.aurora.carevision.domain.admin.model.auth.DepartmentList

interface AdminAuthRepository {

    suspend fun checkUsername(username: String): Boolean
    suspend fun getHospitalList(searchText: String): BaseResponse<AdminHospitalListResponse>
    suspend fun getAdminDepartmentList(hospitalId: String): DepartmentList
    suspend fun adminSignUp(adminUserRequest: AdminUser): AdminUser
    suspend fun adminLogin(adminLoginRequest: AdminUser):AdminUser
}