package com.aurora.carevision.data.remote.admin.auth.di

import com.aurora.carevision.data.remote.admin.auth.datasource.AdminAuthRemoteDataSource
import com.aurora.carevision.data.remote.admin.auth.datasource.DefaultAdminAuthDataSource
import com.aurora.carevision.data.remote.admin.auth.datasource.DefaultNurseAuthDataSource
import com.aurora.carevision.data.remote.admin.auth.datasource.NurseAuthRemoteDataSource
import com.aurora.carevision.data.remote.admin.auth.repository.DefaultNurseAuthRepository
import com.aurora.carevision.data.remote.admin.auth.response.DefaultAdminAuthRepository
import com.aurora.carevision.data.remote.admin.auth.service.AdminAuthService
import com.aurora.carevision.domain.admin.repository.AdminAuthRepository
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
        defaultNurseAuthDataSource: DefaultAdminAuthDataSource
    ): AdminAuthRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindNurseAuthRepository(
        defaultNurseAuthRepository: DefaultAdminAuthRepository
    ): AdminAuthService
}