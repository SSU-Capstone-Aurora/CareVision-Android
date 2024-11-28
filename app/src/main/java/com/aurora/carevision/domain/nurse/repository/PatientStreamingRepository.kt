package com.aurora.carevision.domain.nurse.repository

import com.aurora.carevision.domain.nurse.model.streaming.PatientStreamingInfo

interface PatientStreamingRepository {
    suspend fun getPatientVideoList(): List<PatientStreamingInfo>
}