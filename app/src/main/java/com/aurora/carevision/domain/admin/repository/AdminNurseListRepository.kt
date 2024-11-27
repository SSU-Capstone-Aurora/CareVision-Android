package com.aurora.carevision.domain.admin.repository

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.nurselist.model.NurseListResponse
import com.aurora.carevision.domain.admin.model.nurserequest.NurseList
import com.aurora.carevision.domain.admin.model.nurserequest.NurseRequestList

interface AdminNurseListRepository {
    suspend fun getNurseList(): BaseResponse<NurseListResponse>
}