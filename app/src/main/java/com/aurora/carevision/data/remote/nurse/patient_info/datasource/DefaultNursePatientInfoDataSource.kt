package com.aurora.carevision.data.remote.nurse.patient_info.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.patient_info.model.response.NurseMyPatientInfoListResponse
import com.aurora.carevision.data.remote.nurse.patient_info.service.NursePatientInfoService
import com.aurora.carevision.domain.nurse.repository.NursePatientInfoRepository
import javax.inject.Inject

class DefaultNursePatientInfoDataSource @Inject constructor(
    private val nursePatientInfoService: NursePatientInfoService
): NursePatientInfoDataSource {
    override suspend fun getNursePatientInfo(): BaseResponse<NurseMyPatientInfoListResponse> {
        return nursePatientInfoService.getPatientList()
    }
}