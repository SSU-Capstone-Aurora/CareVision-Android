package com.aurora.carevision.data.remote.nurse.registration.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.registration.model.request.GetPatientNameRequest
import com.aurora.carevision.data.remote.nurse.registration.model.response.GetPatientNameResponse
import com.aurora.carevision.data.remote.nurse.registration.model.response.UnlinkedCameraListResponse
import com.aurora.carevision.data.remote.nurse.registration.model.response.UnlinkedPatientsListResponse
import com.aurora.carevision.data.remote.nurse.registration.service.NursePatientRegistrationService
import javax.inject.Inject

class DefalutNursePatientRegistrationDataSource @Inject constructor(
    private val nursePatientRegistrationService: NursePatientRegistrationService
): NursePatientRegistrationDataSource {
    override suspend fun getRegistrationPatientName(getPatientNameRequest: GetPatientNameRequest): BaseResponse<GetPatientNameResponse> {
        return nursePatientRegistrationService.getRegistrationPatientName(getPatientNameRequest)
    }

    override suspend fun getUnlinkedCameras(): BaseResponse<UnlinkedCameraListResponse> {
        return nursePatientRegistrationService.getUnlinkedCameras()
    }

    override suspend fun getUnlinkedPatients(): BaseResponse<UnlinkedPatientsListResponse> {
        return nursePatientRegistrationService.getUnlinkedPatients()
    }
}