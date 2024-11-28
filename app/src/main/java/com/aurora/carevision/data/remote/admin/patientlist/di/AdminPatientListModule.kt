package com.aurora.carevision.data.remote.admin.patientlist.di

import com.aurora.carevision.core.network.qualifier.Secured
import com.aurora.carevision.data.remote.admin.patientlist.service.AdminPatientListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AdminPatientListModule {
    @Provides
    @Singleton
    fun provideAdminPatientListApi(@Secured retrofit: Retrofit): AdminPatientListService = retrofit.create()
}