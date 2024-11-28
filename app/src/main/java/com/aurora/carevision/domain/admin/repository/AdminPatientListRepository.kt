package com.aurora.carevision.domain.admin.repository

import com.aurora.carevision.domain.admin.model.patient.Patient

interface AdminPatientListRepository {
    suspend fun getAdminPatientList(): List<Patient>
}