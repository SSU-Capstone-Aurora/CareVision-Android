package com.aurora.carevision.data.remote.nurse.auth.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.model.HospitalListResponse
import com.aurora.carevision.data.remote.nurse.auth.service.NurseAuthService
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