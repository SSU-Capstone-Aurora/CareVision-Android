package com.aurora.carevision.data.remote.nurse.video.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.video.model.response.StreamingResponse

interface PatientStreamingDataSource {
    suspend fun getPatientStreamingList(): BaseResponse<StreamingResponse>
}