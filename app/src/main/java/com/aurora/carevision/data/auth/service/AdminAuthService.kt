package com.aurora.carevision.data.auth.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.auth.reponse.HospitalListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AdminAuthService {
    // 로그인 api

    // 회원가입
    // 닉네임 중복 확인 api
    @GET("api/admin/check-username")
    suspend fun checkDuplication(@Query ("username") username: String): String

    // 병원명 조회 api
    @GET("api/admin/hospitals")
    suspend fun searchHospitalList(@Query ("search") searchText: String): BaseResponse<HospitalListResponse>

    // 병원 과 조회 api

    // 회원가입 api

}