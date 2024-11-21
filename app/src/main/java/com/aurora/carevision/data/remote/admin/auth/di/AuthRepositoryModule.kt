package com.aurora.carevision.data.remote.admin.auth.di

import com.aurora.carevision.data.remote.admin.auth.datasource.AdminAuthRemoteDataSource
import com.aurora.carevision.data.remote.admin.auth.datasource.DefaultAdminAuthDataSource
import com.aurora.carevision.data.remote.admin.auth.repository.DefaultAdminAuthRepository
import com.aurora.carevision.domain.admin.repository.AdminAuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AdminAuthRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        defaultAdminAuthDataSource: DefaultAdminAuthDataSource
    ): AdminAuthRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindAdminAuthRepository(
        defaultAdminAuthRepository: DefaultAdminAuthRepository
    ): AdminAuthRepository
}