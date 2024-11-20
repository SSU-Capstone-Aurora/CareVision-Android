package com.aurora.carevision.data.remote.nurse.auth.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseDepartmentListResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseHospitalListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NurseAuthService {
    // 닉네임 중복 확인 api
    @GET("api/check-username")
    suspend fun checkDuplication(@Query ("username") username: String): BaseResponse<Boolean>

    // 회원가입 api
    // 병원리스트 조회 api
    @GET("api/hospitals")
    suspend fun getNurseHospitalList(): BaseResponse<NurseHospitalListResponse>

    // 병원 과 조회 api
    @GET("api/hospitals/departments")
    suspend fun getHospitalDepartmentList(@Query ("hospitalId") hospitalId: Int): BaseResponse<NurseDepartmentListResponse>

    // 로그인 api
}