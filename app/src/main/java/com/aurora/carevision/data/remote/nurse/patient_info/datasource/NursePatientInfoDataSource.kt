package com.aurora.carevision.data.remote.nurse.patient_info.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.patient_info.model.response.NurseMyPatientInfoListResponse

interface NursePatientInfoDataSource {
    suspend fun getNursePatientInfo(): BaseResponse<NurseMyPatientInfoListResponse>
}