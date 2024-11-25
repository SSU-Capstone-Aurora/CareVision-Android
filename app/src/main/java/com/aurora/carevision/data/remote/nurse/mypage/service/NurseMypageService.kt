package com.aurora.carevision.data.remote.nurse.mypage.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.mypage.model.response.NurseMypageResponse
import retrofit2.http.GET

interface NurseMypageService {

    // 간호사 마이페이지 API
    @GET("api/profile")
    suspend fun getNurseMypage(): BaseResponse<NurseMypageResponse>
}