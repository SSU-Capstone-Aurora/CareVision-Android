package com.aurora.carevision.domain.nurse.repository

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseDepartmentListResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseHospitalListResponse
import com.aurora.carevision.data.remote.nurse.auth.model.request.NurseSignUpRequest
import com.aurora.carevision.domain.nurse.model.auth.DepartmentList
import com.aurora.carevision.domain.nurse.model.auth.HospitalList
import com.aurora.carevision.domain.nurse.model.auth.NurseUser

interface NurseAuthRepository {
    suspend fun checkUsername(username: String): Boolean
    suspend fun getNurseHospitalList(): HospitalList
    suspend fun getNurseDepartmentList(hospitalId: Int): DepartmentList
    suspend fun nurseSignUp(nurseUserRequest: NurseUser): NurseUser
}