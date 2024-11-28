package com.aurora.carevision.data.remote.admin.cameralist.di

import com.aurora.carevision.core.network.qualifier.Secured
import com.aurora.carevision.data.remote.admin.cameralist.service.AdminCameraListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AdminCameraListModule {
    @Provides
    @Singleton
    fun provideAdminCameraListApi(@Secured retrofit: Retrofit):AdminCameraListService = retrofit.create()
}