package com.aurora.carevision.data.remote.nurse.registration.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.registration.model.request.GetPatientNameRequest
import com.aurora.carevision.data.remote.nurse.registration.model.response.GetPatientNameResponse
import com.aurora.carevision.data.remote.nurse.registration.model.response.UnlinkedCameraListResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NursePatientRegistrationService {
    @POST("api/patients/name")
    suspend fun getRegistrationPatientName(@Body getPatientNameRequest: GetPatientNameRequest): BaseResponse<GetPatientNameResponse>

    @GET("api/cameras/unlinked")
    suspend fun getUnlinkedCameras(): BaseResponse<UnlinkedCameraListResponse>
}