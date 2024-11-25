package com.aurora.carevision.data.remote.nurse.patient_info.di

import com.aurora.carevision.data.remote.admin.auth.datasource.AdminAuthRemoteDataSource
import com.aurora.carevision.data.remote.admin.auth.datasource.DefaultAdminAuthDataSource
import com.aurora.carevision.data.remote.nurse.auth.datasource.DefaultNurseAuthDataSource
import com.aurora.carevision.data.remote.nurse.auth.datasource.NurseAuthRemoteDataSource
import com.aurora.carevision.data.remote.nurse.auth.repository.DefaultNurseAuthRepository
import com.aurora.carevision.data.remote.nurse.patient_info.datasource.DefaultNursePatientInfoDataSource
import com.aurora.carevision.data.remote.nurse.patient_info.datasource.NursePatientInfoDataSource
import com.aurora.carevision.data.remote.nurse.patient_info.repository.DefaultNursePatientInfoRepository
import com.aurora.carevision.domain.nurse.repository.NurseAuthRepository
import com.aurora.carevision.domain.nurse.repository.NursePatientInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NursePatientInfoRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNursePatientInfoRemoteDataSource(
        defaultNursePatientInfoDataSource: DefaultNursePatientInfoDataSource
    ): NursePatientInfoDataSource

    @Binds
    @Singleton
    abstract fun bindNursePatientInfoRepository(
        defaultNursePatientInfoRepository: DefaultNursePatientInfoRepository
    ): NursePatientInfoRepository
}