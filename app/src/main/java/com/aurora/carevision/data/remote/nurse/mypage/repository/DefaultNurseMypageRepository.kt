package com.aurora.carevision.data.remote.nurse.mypage.repository

import com.aurora.carevision.data.remote.nurse.mypage.datasource.NurseMypageRemoteDataSource
import com.aurora.carevision.data.remote.nurse.mypage.model.response.toDomainModel
import com.aurora.carevision.domain.nurse.model.mypage.NurseMypage
import com.aurora.carevision.domain.nurse.repository.NurseMypageRepository
import javax.inject.Inject

class DefaultNurseMypageRepository @Inject constructor(
    private val nurseMypageDataSource: NurseMypageRemoteDataSource
): NurseMypageRepository {
    override suspend fun getNurseMypage() : NurseMypage {
        return nurseMypageDataSource.getNurseMypage().result.toDomainModel()
    }

}