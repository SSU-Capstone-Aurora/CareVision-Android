package com.aurora.carevision.data.remote.nurse.video.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.video.model.response.SavedVideoListResponse
import com.aurora.carevision.data.remote.nurse.video.model.response.SavedVideoUrlResponse
import com.aurora.carevision.data.remote.nurse.video.model.response.SpecifyLiveStreamingResponse
import com.aurora.carevision.data.remote.nurse.video.model.response.StreamingResponse

interface PatientStreamingDataSource {
    suspend fun getPatientStreamingList(): BaseResponse<StreamingResponse>
    suspend fun getSpecifyPatientStreamingUri(patientId: Int): BaseResponse<SpecifyLiveStreamingResponse>
    suspend fun getSavedVideos(patientId: Int): BaseResponse<SavedVideoListResponse>
    suspend fun getVideoUri(videoId: Int): BaseResponse<SavedVideoUrlResponse>
}