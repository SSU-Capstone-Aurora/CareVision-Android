package com.aurora.carevision.data.remote.admin.auth.repository

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.auth.datasource.AdminAuthRemoteDataSource
import com.aurora.carevision.data.remote.admin.auth.model.AdminDepartmentListResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminHospitalListResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminSignUpResponse
import com.aurora.carevision.data.remote.admin.auth.model.request.AdminSignUpRequest
import com.aurora.carevision.data.remote.admin.auth.model.request.toDataModel
import com.aurora.carevision.data.remote.admin.auth.model.toDomainModel
import com.aurora.carevision.data.remote.admin.auth.model.request.toDataModel
import com.aurora.carevision.data.remote.admin.auth.model.toDomainModel
import com.aurora.carevision.domain.admin.model.auth.AdminUser
import com.aurora.carevision.domain.admin.repository.AdminAuthRepository
import com.aurora.carevision.domain.admin.model.auth.DepartmentList
import com.aurora.carevision.domain.admin.model.auth.HospitalList
import javax.inject.Inject

class DefaultAdminAuthRepository @Inject constructor(
    private val remoteDataSource: AdminAuthRemoteDataSource
) : AdminAuthRepository {
    override suspend fun checkUsername(username: String): Boolean {
        return remoteDataSource.checkUsername(username)
    }

    override suspend fun getHospitalList(searchText: String): BaseResponse<AdminHospitalListResponse> {
        return remoteDataSource.getAdminHospitalList(searchText)
    }

    override suspend fun getAdminDepartmentList(hospitalId: Int): DepartmentList {
        return remoteDataSource.getAdminDepartmentList(hospitalId).result.toDomainModel()
    }

    override suspend fun adminSignUp(adminUserRequest: AdminUser) = remoteDataSource.adminSignUp(adminUserRequest.toDataModel()).result.toDomainModel()
}