package com.aurora.carevision.domain.nurse.repository

import com.aurora.carevision.domain.nurse.model.streaming.PatientStreamingInfo
import com.aurora.carevision.domain.nurse.model.streaming.StreamingSpecifyPatientInfo

interface PatientStreamingRepository {
    suspend fun getPatientVideoList(): List<PatientStreamingInfo>
    suspend fun getSpecifyPatientStreamingUri(patientId: Int): StreamingSpecifyPatientInfo
}