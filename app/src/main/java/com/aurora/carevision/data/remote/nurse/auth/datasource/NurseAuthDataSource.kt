package com.aurora.carevision.data.remote.nurse.auth.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.model.HospitalListResponse

interface NurseAuthRemoteDataSource {
    suspend fun checkUsername(username: String): BaseResponse<Boolean>
    suspend fun getHospitalList(searchText: String): BaseResponse<HospitalListResponse>
}