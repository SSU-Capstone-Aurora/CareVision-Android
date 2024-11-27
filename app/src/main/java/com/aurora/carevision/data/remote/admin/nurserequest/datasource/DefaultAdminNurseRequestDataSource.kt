package com.aurora.carevision.data.remote.admin.nurserequest.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.nurserequest.model.AdminNurseRequestResponse
import com.aurora.carevision.data.remote.admin.nurserequest.service.AdminNurseRequestService

import javax.inject.Inject

class DefaultAdminNurseRequestDataSource @Inject constructor(
    private val nurseRequestService: AdminNurseRequestService
) : AdminNurseRequestDataSource{
    override suspend fun getNurseRequests(): BaseResponse<AdminNurseRequestResponse> {
        return nurseRequestService.getNurseRequests()
    }

    override suspend fun acceptNurseRequests(nurseId: Int): BaseResponse<Unit> {
        return nurseRequestService.acceptNurseRequest(nurseId)
    }
}