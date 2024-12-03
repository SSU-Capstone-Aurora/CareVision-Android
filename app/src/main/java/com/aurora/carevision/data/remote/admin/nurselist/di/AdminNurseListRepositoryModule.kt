package com.aurora.carevision.data.remote.admin.nurselist.di

import com.aurora.carevision.data.remote.admin.nurselist.datasource.AdminNurseListRemoteDataSource
import com.aurora.carevision.data.remote.admin.nurselist.datasource.DefaultNurseListDataSource
import com.aurora.carevision.data.remote.admin.nurselist.repository.DefaultNurseListRepository
import com.aurora.carevision.domain.admin.repository.AdminNurseListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AdminNurseListRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNurseListRemoteDataSource(
        defaultNurseListDataSource: DefaultNurseListDataSource
    ): AdminNurseListRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindNurseListRepository(
        defaultNurseListRepository: DefaultNurseListRepository
    ): AdminNurseListRepository
}