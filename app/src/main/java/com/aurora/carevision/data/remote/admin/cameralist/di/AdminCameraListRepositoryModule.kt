package com.aurora.carevision.data.remote.admin.cameralist.di

import com.aurora.carevision.data.remote.admin.cameralist.datasource.AdminCameraListDataSource
import com.aurora.carevision.data.remote.admin.cameralist.datasource.DefaultAdminCameraListDataSource
import com.aurora.carevision.data.remote.admin.cameralist.repository.DefaultAdminCameraListRepository
import com.aurora.carevision.domain.admin.repository.AdminCameraListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AdminCameraListRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCameraListRemoteDataSource(
        defaultCameraListDataSource: DefaultAdminCameraListDataSource
    ):AdminCameraListDataSource

    @Binds
    @Singleton
    abstract fun bindCameraListRepository(
        defaultCameraListRepository: DefaultAdminCameraListRepository
    ): AdminCameraListRepository
}