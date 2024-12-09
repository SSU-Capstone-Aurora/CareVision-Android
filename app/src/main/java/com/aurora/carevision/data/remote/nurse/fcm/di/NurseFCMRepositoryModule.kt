package com.aurora.carevision.data.remote.nurse.fcm.di

import com.aurora.carevision.data.remote.nurse.auth.datasource.DefaultNurseAuthDataSource
import com.aurora.carevision.data.remote.nurse.auth.datasource.NurseAuthRemoteDataSource
import com.aurora.carevision.data.remote.nurse.auth.repository.DefaultNurseAuthRepository
import com.aurora.carevision.data.remote.nurse.fcm.datasource.DefaultNurseFCMDataSource
import com.aurora.carevision.data.remote.nurse.fcm.datasource.NurseFCMDataSource
import com.aurora.carevision.data.remote.nurse.fcm.repository.DefaultNurseFCMRepository
import com.aurora.carevision.domain.nurse.repository.NurseAuthRepository
import com.aurora.carevision.domain.nurse.repository.NurseFCMRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class NurseFCMRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        defaultNurseFCMDataSource: DefaultNurseFCMDataSource
    ): NurseFCMDataSource

    @Binds
    @Singleton
    abstract fun bindNurseFCMRepository(
        defaultNurseFCMRepository: DefaultNurseFCMRepository
    ): NurseFCMRepository
}