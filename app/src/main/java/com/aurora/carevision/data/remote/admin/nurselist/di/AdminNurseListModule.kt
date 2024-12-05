package com.aurora.carevision.data.remote.admin.nurselist.di

import com.aurora.carevision.core.network.qualifier.Secured
import com.aurora.carevision.data.remote.admin.nurselist.service.NurseListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AdminNurseListModule {
    @Provides
    @Singleton
    fun provideNurseListApi(@Secured retrofit: Retrofit): NurseListService = retrofit.create()
}