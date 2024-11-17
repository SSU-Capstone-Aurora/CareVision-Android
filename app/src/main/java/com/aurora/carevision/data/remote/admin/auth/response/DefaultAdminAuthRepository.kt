package com.aurora.carevision.data.remote.admin.auth.response

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.auth.datasource.AdminAuthRemoteDataSource
import com.aurora.carevision.data.remote.nurse.auth.model.HospitalListResponse
import com.aurora.carevision.domain.nurse.repository.NurseAuthRepository

import javax.inject.Inject

class DefaultAdminAuthRepository @Inject constructor(
    private val remoteDataSource: AdminAuthRemoteDataSource
) : NurseAuthRepository {
    override suspend fun checkUsername(username: String): Boolean {
        return remoteDataSource.checkUsername(username)
    }

    override suspend fun getHospitalList(searchText: String): BaseResponse<HospitalListResponse> {
        return remoteDataSource.getHospitalList(searchText)
    }
}