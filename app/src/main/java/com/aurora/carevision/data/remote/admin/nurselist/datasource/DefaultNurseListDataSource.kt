package com.aurora.carevision.data.remote.admin.nurselist.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.nurselist.model.NurseListResponse
import com.aurora.carevision.data.remote.admin.nurselist.service.NurseListService
import com.aurora.carevision.domain.admin.model.nurserequest.NurseList
import javax.inject.Inject

class DefaultNurseListDataSource @Inject constructor(
    private val nurseListService: NurseListService
) : AdminNurseListRemoteDataSource {
    override suspend fun getNurseList(): BaseResponse<NurseListResponse> {
        return nurseListService.getNurseList()
    }
}