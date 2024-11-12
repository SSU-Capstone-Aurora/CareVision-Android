package com.aurora.carevision.data.remote.auth.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.auth.model.HospitalListResponse
import com.aurora.carevision.data.remote.auth.service.NurseAuthService
import javax.inject.Inject


class DefaultNurseAuthDataSource @Inject constructor(
    private val nurseAuthService: NurseAuthService
) : NurseAuthRemoteDataSource {
    override suspend fun checkUsername(username: String): BaseResponse<Boolean> {
        return nurseAuthService.checkDuplication(username)
    }

    override suspend fun getHospitalList(searchText: String): BaseResponse<HospitalListResponse> {
        return nurseAuthService.getHospitalList(searchText)
    }
}