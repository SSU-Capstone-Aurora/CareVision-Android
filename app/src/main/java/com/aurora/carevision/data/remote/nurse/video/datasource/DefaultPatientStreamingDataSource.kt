package com.aurora.carevision.data.remote.nurse.video.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.video.model.response.SavedVideoUrlResponse
import com.aurora.carevision.data.remote.nurse.video.model.response.SpecifyLiveStreamingResponse
import com.aurora.carevision.data.remote.nurse.video.model.response.StreamingResponse
import com.aurora.carevision.data.remote.nurse.video.model.response.toDomainModel
import com.aurora.carevision.data.remote.nurse.video.service.PatientStreamingService
import javax.inject.Inject

class DefaultPatientStreamingDataSource @Inject constructor(
    private val patientStreamingService: PatientStreamingService
): PatientStreamingDataSource {
    override suspend fun getPatientStreamingList() =
        patientStreamingService.getPatientStreamingList()

    override suspend fun getSpecifyPatientStreamingUri(patientId: Int): BaseResponse<SpecifyLiveStreamingResponse> {
        return patientStreamingService.getSpecifyPatientStreamingUri(patientId)
    }

    override suspend fun getSavedVideos(patientId: Int) =
        patientStreamingService.getSavedVideos(patientId)

    override suspend fun getVideoUri(videoId: Int): BaseResponse<SavedVideoUrlResponse> = patientStreamingService.getVideoUri(videoId)
}