package com.aurora.carevision.domain.nurse.repository

import com.aurora.carevision.domain.nurse.model.streaming.PatientStreamingInfo
import com.aurora.carevision.domain.nurse.model.streaming.SavedVideoInfo
import com.aurora.carevision.domain.nurse.model.streaming.StreamingSpecifyPatientInfo

interface PatientStreamingRepository {
    suspend fun getPatientVideoList(): List<PatientStreamingInfo>
    suspend fun getSpecifyPatientStreamingUri(patientId: Int): StreamingSpecifyPatientInfo
    suspend fun getSavedVideos(patientId: Int): List<SavedVideoInfo>
    suspend fun getVideoUri(videoId: Int): String
}