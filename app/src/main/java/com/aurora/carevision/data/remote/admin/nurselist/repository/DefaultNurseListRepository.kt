package com.aurora.carevision.data.remote.admin.nurselist.repository

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.nurselist.datasource.AdminNurseListRemoteDataSource
import com.aurora.carevision.data.remote.admin.nurselist.model.NurseListResponse
import com.aurora.carevision.domain.admin.model.nurserequest.NurseList
import com.aurora.carevision.domain.admin.repository.AdminNurseListRepository
import javax.inject.Inject

class DefaultNurseListRepository @Inject constructor(
    private val remoteDataSource: AdminNurseListRemoteDataSource
) : AdminNurseListRepository {
    override suspend fun getNurseList(): BaseResponse<NurseListResponse> {
        return remoteDataSource.getNurseList()
    }
}