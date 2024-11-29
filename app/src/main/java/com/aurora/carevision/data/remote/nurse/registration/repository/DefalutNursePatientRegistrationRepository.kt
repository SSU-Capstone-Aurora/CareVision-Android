package com.aurora.carevision.data.remote.nurse.registration.repository

import com.aurora.carevision.data.remote.nurse.registration.datasource.NursePatientRegistrationDataSource
import com.aurora.carevision.data.remote.nurse.registration.model.request.toDataModel
import com.aurora.carevision.data.remote.nurse.registration.model.response.toDomainModel
import com.aurora.carevision.domain.nurse.repository.NursePatientRegistrationRepository
import javax.inject.Inject

class DefalutNursePatientRegistrationRepository @Inject constructor(
    private val nursePatientRegistrationDataSource: NursePatientRegistrationDataSource
) : NursePatientRegistrationRepository {
    override suspend fun getRegistrationPatientName(patientCode: String): String {
        return nursePatientRegistrationDataSource.getRegistrationPatientName(patientCode.toDataModel()).result.toDomainModel()
    }

    override suspend fun getUnlinkedCameras() = nursePatientRegistrationDataSource.getUnlinkedCameras().result.toDomainModel()
}