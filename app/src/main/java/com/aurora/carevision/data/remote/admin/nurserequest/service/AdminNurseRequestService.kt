package com.aurora.carevision.data.remote.admin.nurserequest.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.nurserequest.model.AdminNurseRequestResponse
import retrofit2.http.GET

interface AdminNurseRequestService {
    //간호사 요청 리스트 api
    @GET("api/admin/nurses/requests")
    suspend fun getNurseRequests(): BaseResponse<AdminNurseRequestResponse>
}