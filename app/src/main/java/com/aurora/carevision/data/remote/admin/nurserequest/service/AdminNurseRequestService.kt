package com.aurora.carevision.data.remote.admin.nurserequest.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.nurserequest.model.AdminNurseRequestResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AdminNurseRequestService {
    //간호사 요청 리스트 api
    @GET("api/admin/nurses/requests")
    suspend fun getNurseRequests(): BaseResponse<AdminNurseRequestResponse>

    @POST("api/admin/nurses/requests/{nurseId}")
    suspend fun acceptNurseRequest(@Path("nurseId") nurseId: Int):BaseResponse<Unit>
}