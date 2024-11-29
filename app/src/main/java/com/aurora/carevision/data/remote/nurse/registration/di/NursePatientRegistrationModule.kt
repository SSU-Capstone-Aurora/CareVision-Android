package com.aurora.carevision.data.remote.nurse.registration.di

import com.aurora.carevision.core.network.qualifier.Secured
import com.aurora.carevision.data.remote.nurse.registration.service.NursePatientRegistrationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NursePatientRegistrationModule {

    @Provides
    @Singleton
    fun provideNursePatientRegistrationApi(@Secured retrofit: Retrofit): NursePatientRegistrationService =
        retrofit.create()
}