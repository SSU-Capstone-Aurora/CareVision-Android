package com.aurora.carevision.data.remote.admin.nurserequest.repository

import com.aurora.carevision.data.remote.admin.nurserequest.datasource.AdminNurseRequestDataSource
import com.aurora.carevision.data.remote.admin.nurserequest.model.toDomainModel
import com.aurora.carevision.domain.admin.model.nurserequest.NurseRequestList
import com.aurora.carevision.domain.admin.repository.AdminNurseRequestRepository

import javax.inject.Inject

class DefaultAdminNurseRequestRepository @Inject constructor(
    private val adminNurseRequestDataSource: AdminNurseRequestDataSource
): AdminNurseRequestRepository {
    override suspend fun getNurseRequests(): NurseRequestList {
        return adminNurseRequestDataSource.getNurseRequests().result.toDomainModel()
    }
}