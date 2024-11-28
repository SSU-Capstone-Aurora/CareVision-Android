package com.aurora.carevision.data.remote.nurse.video.di

import com.aurora.carevision.data.remote.nurse.patient_info.datasource.DefaultNursePatientInfoDataSource
import com.aurora.carevision.data.remote.nurse.patient_info.datasource.NursePatientInfoDataSource
import com.aurora.carevision.data.remote.nurse.patient_info.repository.DefaultNursePatientInfoRepository
import com.aurora.carevision.data.remote.nurse.video.datasource.DefaultPatientStreamingDataSource
import com.aurora.carevision.data.remote.nurse.video.datasource.PatientStreamingDataSource
import com.aurora.carevision.data.remote.nurse.video.repository.DefaultPatientStreamingRepository
import com.aurora.carevision.domain.nurse.repository.NursePatientInfoRepository
import com.aurora.carevision.domain.nurse.repository.PatientStreamingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PatientStreamingRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPatientStreamingRemoteDataSource(
        defaultPatientStreamingDataSource: DefaultPatientStreamingDataSource
    ): PatientStreamingDataSource

    @Binds
    @Singleton
    abstract fun bindPatientStreamingRepository(
        defaultPatientStreamingRepository: DefaultPatientStreamingRepository
    ): PatientStreamingRepository
}