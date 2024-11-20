package com.aurora.carevision.domain.nurse.repository

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseDepartmentListResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseHospitalListResponse
import com.aurora.carevision.domain.nurse.model.auth.HospitalList

interface NurseAuthRepository {
    suspend fun checkUsername(username: String): Boolean
    suspend fun getNurseHospitalList(): HospitalList
    suspend fun getNurseDepartmentList(hospitalId: Int): BaseResponse<NurseDepartmentListResponse>
}