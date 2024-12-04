package com.aurora.carevision.data.remote.nurse.registration.di

import com.aurora.carevision.data.remote.nurse.registration.datasource.DefalutNursePatientRegistrationDataSource
import com.aurora.carevision.data.remote.nurse.registration.datasource.NursePatientRegistrationDataSource
import com.aurora.carevision.data.remote.nurse.registration.repository.DefalutNursePatientRegistrationRepository
import com.aurora.carevision.domain.nurse.repository.NursePatientRegistrationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NursePatientRegistrationRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNursePatientRegistrationRemoteDataSource(
        defaultNursePatientRegistrationDataSource: DefalutNursePatientRegistrationDataSource
    ): NursePatientRegistrationDataSource

    @Binds
    @Singleton
    abstract fun bindNursePatientRegistrationRepository(
        defaultNursePatientRegistrationRepository: DefalutNursePatientRegistrationRepository
    ): NursePatientRegistrationRepository

}