package com.aurora.carevision.data.remote.nurse.video.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.video.model.response.StreamingResponse
import retrofit2.http.GET

interface PatientStreamingService {

    @GET("/api/streaming")
    suspend fun getPatientStreamingList(): BaseResponse<StreamingResponse>
}