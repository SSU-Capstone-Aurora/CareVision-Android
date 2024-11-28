package com.aurora.carevision.data.remote.nurse.video.datasource

import com.aurora.carevision.data.remote.nurse.video.service.PatientStreamingService
import javax.inject.Inject

class DefaultPatientStreamingDataSource @Inject constructor(
    private val patientStreamingService: PatientStreamingService
): PatientStreamingDataSource {
    override suspend fun getPatientStreamingList() = patientStreamingService.getPatientStreamingList()
}