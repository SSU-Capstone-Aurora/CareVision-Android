package com.aurora.carevision.data.remote.admin.patientlist.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.patientlist.model.AdminPatientListResponse
import com.aurora.carevision.data.remote.admin.patientlist.service.AdminPatientListService
import javax.inject.Inject

class DefaultAdminPatientListDataSource @Inject constructor(
    private val adminPatientListService: AdminPatientListService
):AdminPatientListDataSource{
    override suspend fun getAdminPatientList(size: Int, lastIdx: Int): BaseResponse<AdminPatientListResponse> {
        return adminPatientListService.getAdminPatientList(size, lastIdx)
    }
}