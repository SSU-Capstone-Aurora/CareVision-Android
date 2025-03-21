package com.aurora.carevision.data.remote.admin.patientlist.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.patientlist.model.AdminPatientListResponse

interface AdminPatientListDataSource {
    suspend fun getAdminPatientList(size: Int, lastIdx: Int): BaseResponse<AdminPatientListResponse>
}