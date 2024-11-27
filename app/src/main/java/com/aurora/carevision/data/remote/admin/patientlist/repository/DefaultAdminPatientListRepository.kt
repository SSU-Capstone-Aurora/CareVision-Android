package com.aurora.carevision.data.remote.admin.patientlist.repository

import com.aurora.carevision.data.remote.admin.patientlist.datasource.AdminPatientListDataSource
import com.aurora.carevision.data.remote.admin.patientlist.model.toDomainModel
import com.aurora.carevision.domain.admin.model.patient.Patient
import com.aurora.carevision.domain.admin.repository.AdminPatientListRepository
import javax.inject.Inject

class DefaultAdminPatientListRepository @Inject constructor(
    private val adminPatientListDataSource: AdminPatientListDataSource
): AdminPatientListRepository {
    override suspend fun getAdminPatientList(): List<Patient> {
        return adminPatientListDataSource.getAdminPatientList().result.toDomainModel()
    }
}