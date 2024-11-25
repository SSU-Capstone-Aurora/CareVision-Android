package com.aurora.carevision.data.remote.nurse.mypage.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.mypage.model.response.NurseMypageResponse
import com.aurora.carevision.data.remote.nurse.mypage.service.NurseMypageService
import javax.inject.Inject

class DefaultNurseMypageDataSource @Inject constructor(
    private val nurseMypageService: NurseMypageService
): NurseMypageRemoteDataSource{
    override suspend fun getNurseMypage(): BaseResponse<NurseMypageResponse> {
        return nurseMypageService.getNurseMypage()
    }
}