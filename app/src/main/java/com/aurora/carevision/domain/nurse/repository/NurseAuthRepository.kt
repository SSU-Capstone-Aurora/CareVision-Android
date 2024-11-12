package com.aurora.carevision.domain.nurse.repository

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.auth.reponse.HospitalListResponse

interface NurseAuthRepository {
    suspend fun checkUsername(username: String): BaseResponse<Boolean>
    suspend fun getHospitalList(searchText: String): BaseResponse<HospitalListResponse>
}