package com.aurora.carevision.data.remote.nurse.patient_info.di

import com.aurora.carevision.core.network.qualifier.Secured
import com.aurora.carevision.core.network.qualifier.Unsecured
import com.aurora.carevision.data.remote.nurse.auth.service.NurseAuthService
import com.aurora.carevision.data.remote.nurse.patient_info.service.NursePatientInfoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NursePatientInfoModule {
    @Provides
    @Singleton
    fun provideNursePatientInfoApi(@Secured retrofit: Retrofit): NursePatientInfoService = retrofit.create()

}