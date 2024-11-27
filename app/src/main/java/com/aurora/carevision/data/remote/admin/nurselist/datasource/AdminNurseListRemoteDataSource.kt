package com.aurora.carevision.data.remote.admin.nurselist.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.nurselist.model.NurseListResponse

interface AdminNurseListRemoteDataSource {
    suspend fun getNurseList(): BaseResponse<NurseListResponse>
}