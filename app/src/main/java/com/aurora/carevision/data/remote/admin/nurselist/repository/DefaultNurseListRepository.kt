package com.aurora.carevision.data.remote.admin.nurselist.repository

import com.aurora.carevision.data.remote.admin.nurselist.datasource.AdminNurseListRemoteDataSource
import com.aurora.carevision.data.remote.admin.nurselist.model.toDomainModel
import com.aurora.carevision.domain.admin.model.nurse.NurseInfo
import com.aurora.carevision.domain.admin.repository.AdminNurseListRepository
import javax.inject.Inject

class DefaultNurseListRepository @Inject constructor(
    private val adminNurseListDataSource: AdminNurseListRemoteDataSource
) : AdminNurseListRepository {
    override suspend fun getNurseList(): List<NurseInfo> {
        return adminNurseListDataSource.getNurseList().result.toDomainModel()
    }
}