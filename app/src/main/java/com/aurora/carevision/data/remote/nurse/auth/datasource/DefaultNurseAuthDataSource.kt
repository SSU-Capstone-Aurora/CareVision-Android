package com.aurora.carevision.data.remote.nurse.auth.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseDepartmentListResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseHospitalListResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseSignUpResponse
import com.aurora.carevision.data.remote.nurse.auth.model.request.NurseSignUpRequest
import com.aurora.carevision.data.remote.nurse.auth.service.NurseAuthService
import javax.inject.Inject


class DefaultNurseAuthDataSource @Inject constructor(
    private val nurseAuthService: NurseAuthService
) : NurseAuthRemoteDataSource {
    override suspend fun checkUsername(username: String): Boolean {
        return nurseAuthService.checkDuplication(username).result
    }

    override suspend fun getNurseHospitalList(): BaseResponse<NurseHospitalListResponse> {
        return nurseAuthService.getNurseHospitalList()
    }

    override suspend fun getNurseDepartmentList(hospitalId: Int): BaseResponse<NurseDepartmentListResponse> {
        return nurseAuthService.getHospitalDepartmentList(hospitalId)
    }

    override suspend fun nurseSignUp(nurseSignUpRequest: NurseSignUpRequest): BaseResponse<NurseSignUpResponse> {
        return nurseAuthService.nurseSignUp(nurseSignUpRequest)
    }
}