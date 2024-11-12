package com.aurora.carevision.data.remote.auth.di

import com.aurora.carevision.data.remote.auth.datasource.DefaultNurseAuthDataSource
import com.aurora.carevision.data.remote.auth.datasource.NurseAuthRemoteDataSource
import com.aurora.carevision.data.remote.auth.repository.DefaultNurseAuthRepository
import com.aurora.carevision.domain.nurse.repository.NurseAuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        defaultNurseAuthDataSource: DefaultNurseAuthDataSource
    ): NurseAuthRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindNurseAuthRepository(
        defaultNurseAuthRepository: DefaultNurseAuthRepository
    ): NurseAuthRepository
}