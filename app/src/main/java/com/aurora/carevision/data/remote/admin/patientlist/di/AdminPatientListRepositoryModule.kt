package com.aurora.carevision.data.remote.admin.patientlist.di

import com.aurora.carevision.data.remote.admin.patientlist.datasource.AdminPatientListDataSource
import com.aurora.carevision.data.remote.admin.patientlist.datasource.DefaultAdminPatientListDataSource
import com.aurora.carevision.data.remote.admin.patientlist.repository.DefaultAdminPatientListRepository
import com.aurora.carevision.domain.admin.repository.AdminPatientListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class AdminPatientListRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPatientListRemoteDataSource(
        defaultPatientListDataSource: DefaultAdminPatientListDataSource
    ): AdminPatientListDataSource

    @Binds
    @Singleton
    abstract fun bindPatientListRepository(
        defaultPatientListRepository: DefaultAdminPatientListRepository
    ): AdminPatientListRepository
}