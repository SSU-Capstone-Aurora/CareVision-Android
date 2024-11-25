package com.aurora.carevision.data.remote.nurse.patient_info.repository

import com.aurora.carevision.data.remote.nurse.patient_info.datasource.NursePatientInfoDataSource
import com.aurora.carevision.data.remote.nurse.patient_info.model.response.toDomainModel
import com.aurora.carevision.domain.nurse.model.Patient
import com.aurora.carevision.domain.nurse.repository.NursePatientInfoRepository
import javax.inject.Inject

class DefaultNursePatientInfoRepository @Inject constructor(
    private val nursePatientInfoDataSource: NursePatientInfoDataSource
): NursePatientInfoRepository {
    override suspend fun getPatientList(): List<Patient> {
        return nursePatientInfoDataSource.getNursePatientInfo().result.toDomainModel()
    }

}