package com.aurora.carevision.data.remote.admin.auth.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.model.HospitalListResponse

interface AdminAuthRemoteDataSource {
    suspend fun checkUsername(username: String): Boolean
    suspend fun getHospitalList(searchText: String): BaseResponse<HospitalListResponse>
}