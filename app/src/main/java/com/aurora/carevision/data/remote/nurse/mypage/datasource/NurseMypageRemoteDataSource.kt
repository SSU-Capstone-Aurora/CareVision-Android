package com.aurora.carevision.data.remote.nurse.mypage.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.mypage.model.response.NurseMypageResponse

interface NurseMypageRemoteDataSource {
    suspend fun getNurseMypage(): BaseResponse<NurseMypageResponse>
}