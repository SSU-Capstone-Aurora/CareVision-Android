package com.aurora.carevision.domain.nurse.repository

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.model.HospitalListResponse

interface NurseAuthRepository {
    suspend fun checkUsername(username: String): Boolean
    suspend fun getHospitalList(searchText: String): BaseResponse<HospitalListResponse>
}