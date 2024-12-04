package com.aurora.carevision.data.remote.nurse.video.di

import com.aurora.carevision.core.network.qualifier.Secured
import com.aurora.carevision.data.remote.nurse.video.service.PatientStreamingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PatientStreamingModule {

    @Provides
    @Singleton
    fun providePatientStreamingApi(@Secured retrofit: Retrofit): PatientStreamingService =
        retrofit.create()
}