package com.aurora.carevision.data.remote.admin.nurselist.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.nurselist.model.NurseListResponse
import retrofit2.http.GET

interface NurseListService {
    @GET("api/admin/nurses")
    suspend fun getNurseList(): BaseResponse<NurseListResponse>
}