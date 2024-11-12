package com.aurora.carevision.data.auth.di

import com.aurora.carevision.data.auth.datasource.DefaultNurseAuthDataSource
import com.aurora.carevision.data.auth.datasource.NurseAuthRemoteDataSource
import com.aurora.carevision.data.auth.repository.DefaultNurseAuthRepository
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