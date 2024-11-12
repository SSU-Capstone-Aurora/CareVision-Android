package com.aurora.carevision.data.remote.auth.repository

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.auth.datasource.NurseAuthRemoteDataSource
import com.aurora.carevision.data.remote.auth.model.HospitalListResponse
import com.aurora.carevision.domain.nurse.repository.NurseAuthRepository
import javax.inject.Inject

class DefaultNurseAuthRepository @Inject constructor(
    private val remoteDataSource: NurseAuthRemoteDataSource
) : NurseAuthRepository {
    override suspend fun checkUsername(username: String): BaseResponse<Boolean> {
        return remoteDataSource.checkUsername(username)
    }

    override suspend fun getHospitalList(searchText: String): BaseResponse<HospitalListResponse> {
        return remoteDataSource.getHospitalList(searchText)
    }
}