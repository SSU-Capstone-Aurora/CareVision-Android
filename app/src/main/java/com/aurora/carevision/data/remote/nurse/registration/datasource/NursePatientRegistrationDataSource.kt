package com.aurora.carevision.data.remote.nurse.registration.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.registration.model.request.GetPatientNameRequest
import com.aurora.carevision.data.remote.nurse.registration.model.request.PostNewPatientRequest
import com.aurora.carevision.data.remote.nurse.registration.model.response.GetPatientNameResponse
import com.aurora.carevision.data.remote.nurse.registration.model.response.UnlinkedCameraListResponse
import com.aurora.carevision.data.remote.nurse.registration.model.response.UnlinkedPatientsListResponse

interface NursePatientRegistrationDataSource {
    suspend fun getRegistrationPatientName(getPatientNameRequest: GetPatientNameRequest): BaseResponse<GetPatientNameResponse>
    suspend fun getUnlinkedCameras(): BaseResponse<UnlinkedCameraListResponse>
    suspend fun getUnlinkedPatients(): BaseResponse<UnlinkedPatientsListResponse>
    suspend fun postNewPatient(postNewPatientResponse: PostNewPatientRequest): BaseResponse<Unit>
    suspend fun postAlreadyPatient(patientId: Int): BaseResponse<Unit>
}