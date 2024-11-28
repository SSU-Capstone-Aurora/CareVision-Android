package com.aurora.carevision.data.remote.nurse.patient_info.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.patient_info.model.response.NurseMyPatientInfoListResponse
import retrofit2.http.GET

interface NursePatientInfoService {
    @GET("api/patients")
    suspend fun getPatientList(): BaseResponse<NurseMyPatientInfoListResponse>
}