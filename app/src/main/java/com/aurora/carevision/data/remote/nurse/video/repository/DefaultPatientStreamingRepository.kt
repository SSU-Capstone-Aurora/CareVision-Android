package com.aurora.carevision.data.remote.nurse.video.repository

import com.aurora.carevision.data.remote.nurse.video.datasource.PatientStreamingDataSource
import com.aurora.carevision.data.remote.nurse.video.model.response.toDomainModel
import com.aurora.carevision.domain.nurse.model.streaming.PatientStreamingInfo
import com.aurora.carevision.domain.nurse.model.streaming.StreamingSpecifyPatientInfo
import com.aurora.carevision.domain.nurse.repository.PatientStreamingRepository
import javax.inject.Inject

class DefaultPatientStreamingRepository @Inject constructor(
    private val patientStreamingDataSource: PatientStreamingDataSource
) : PatientStreamingRepository {
    override suspend fun getPatientVideoList(): List<PatientStreamingInfo> {
        return patientStreamingDataSource.getPatientStreamingList().result.toDomainModel()
    }

    override suspend fun getSpecifyPatientStreamingUri(patientId: Int): StreamingSpecifyPatientInfo {
        return patientStreamingDataSource.getSpecifyPatientStreamingUri(patientId).result.toDomainModel()
    }

    override suspend fun getSavedVideos(patientId: Int) =
        patientStreamingDataSource.getSavedVideos(patientId).result.toDomainModel()
}