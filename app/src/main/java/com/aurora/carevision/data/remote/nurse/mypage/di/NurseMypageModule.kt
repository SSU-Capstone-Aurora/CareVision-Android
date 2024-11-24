package com.aurora.carevision.data.remote.nurse.mypage.di

import com.aurora.carevision.core.network.qualifier.Secured
import com.aurora.carevision.data.remote.nurse.mypage.service.NurseMypageService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NurseMypageModule {

    @Provides
    @Singleton
    fun provideNurseMypageApi(@Secured retrofit: Retrofit): NurseMypageService = retrofit.create()
}