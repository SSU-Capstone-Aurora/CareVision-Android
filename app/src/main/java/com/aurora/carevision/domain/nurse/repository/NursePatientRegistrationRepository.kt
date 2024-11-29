package com.aurora.carevision.domain.nurse.repository

import com.aurora.carevision.domain.nurse.model.Camera

interface NursePatientRegistrationRepository {
    suspend fun getRegistrationPatientName(patientCode: String): String
    suspend fun getUnlinkedCameras():List<Camera>
}