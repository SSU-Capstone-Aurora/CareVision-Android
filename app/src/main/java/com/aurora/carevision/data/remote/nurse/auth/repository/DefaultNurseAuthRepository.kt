package com.aurora.carevision.data.remote.nurse.auth.repository

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.datasource.NurseAuthRemoteDataSource
import com.aurora.carevision.data.remote.nurse.auth.model.NurseDepartmentListResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseHospitalListResponse
import com.aurora.carevision.data.remote.nurse.auth.model.toDomainModel
import com.aurora.carevision.domain.nurse.model.auth.HospitalList
import com.aurora.carevision.domain.nurse.repository.NurseAuthRepository
import javax.inject.Inject

class DefaultNurseAuthRepository @Inject constructor(
    private val remoteDataSource: NurseAuthRemoteDataSource
) : NurseAuthRepository {
    override suspend fun checkUsername(username: String): Boolean {
        return remoteDataSource.checkUsername(username)
    }

    override suspend fun getNurseHospitalList(): HospitalList{
        return remoteDataSource.getNurseHospitalList().result.toDomainModel()
    }

    override suspend fun getNurseDepartmentList(hospitalId: Int): BaseResponse<NurseDepartmentListResponse> {
        return remoteDataSource.getNurseDepartmentList(hospitalId)
    }
}