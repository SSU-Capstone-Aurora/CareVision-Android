package com.aurora.carevision.data.remote.admin.nurserequest.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.nurserequest.model.AdminNurseRequestResponse

interface AdminNurseRequestDataSource {
    suspend fun getNurseRequests(): BaseResponse<AdminNurseRequestResponse>
}