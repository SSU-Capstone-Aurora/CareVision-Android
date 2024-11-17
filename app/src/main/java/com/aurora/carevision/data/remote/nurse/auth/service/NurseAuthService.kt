package com.aurora.carevision.data.remote.nurse.auth.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.model.HospitalListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NurseAuthService {
    // 닉네임 중복 확인 api
    @GET("api/check-username")
    suspend fun checkDuplication(@Query ("username") username: String): BaseResponse<Boolean>

    // 회원가입 api
    // 병원명 조회 api
    @GET("api/admin/hospitals")
    suspend fun getHospitalList(@Query ("search") searchText: String): BaseResponse<HospitalListResponse>

    // 로그인 api
}