package com.aurora.carevision.domain.nurse.repository

import com.aurora.carevision.domain.nurse.model.Patient

interface NursePatientInfoRepository {
    suspend fun getPatientList(): List<Patient>
}