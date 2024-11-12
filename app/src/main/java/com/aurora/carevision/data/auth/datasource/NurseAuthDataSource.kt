package com.aurora.carevision.data.auth.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.auth.reponse.HospitalListResponse

interface NurseAuthRemoteDataSource {
    suspend fun checkUsername(username: String): BaseResponse<Boolean>
    suspend fun getHospitalList(searchText: String): BaseResponse<HospitalListResponse>
}