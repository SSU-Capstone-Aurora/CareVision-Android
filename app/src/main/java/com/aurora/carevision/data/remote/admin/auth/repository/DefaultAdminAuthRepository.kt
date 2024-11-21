package com.aurora.carevision.data.remote.admin.auth.repository

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.auth.datasource.AdminAuthRemoteDataSource
import com.aurora.carevision.data.remote.admin.auth.model.HospitalListResponse
import com.aurora.carevision.domain.admin.repository.AdminAuthRepository
import javax.inject.Inject

class DefaultAdminAuthRepository @Inject constructor(
    private val remoteDataSource: AdminAuthRemoteDataSource
) : AdminAuthRepository {
    override suspend fun checkUsername(username: String): Boolean {
        return remoteDataSource.checkUsername(username)
    }

    override suspend fun getHospitalList(searchText: String): BaseResponse<HospitalListResponse> {
        return remoteDataSource.getHospitalList(searchText)
    }
}