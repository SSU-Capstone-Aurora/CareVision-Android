package com.aurora.carevision.domain.nurse.repository

import com.aurora.carevision.domain.nurse.model.Camera
import com.aurora.carevision.domain.nurse.model.Patient

interface NursePatientRegistrationRepository {
    suspend fun getRegistrationPatientName(patientCode: String): String
    suspend fun getUnlinkedCameras():List<Camera>
    suspend fun getUnlinkedPatients():List<Patient>
}