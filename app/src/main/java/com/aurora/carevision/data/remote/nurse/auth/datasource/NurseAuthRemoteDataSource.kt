package com.aurora.carevision.data.remote.nurse.auth.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseDepartmentListResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseHospitalListResponse

interface NurseAuthRemoteDataSource {
    suspend fun checkUsername(username: String): Boolean
    suspend fun getNurseHospitalList(): BaseResponse<NurseHospitalListResponse>
    suspend fun getNurseDepartmentList(hospitalId: Int): BaseResponse<NurseDepartmentListResponse>
}