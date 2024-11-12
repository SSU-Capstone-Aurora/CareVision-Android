package com.aurora.carevision.data.auth.repository

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.auth.datasource.NurseAuthRemoteDataSource
import com.aurora.carevision.data.auth.reponse.HospitalListResponse
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