package com.aurora.carevision.data.remote.nurse.auth.di

import android.content.Context
import android.content.SharedPreferences
import com.aurora.carevision.core.network.qualifier.Unsecured
import com.aurora.carevision.data.local.auth.TokenProvider
import com.aurora.carevision.data.remote.nurse.auth.service.NurseAuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    // NurseAuthService 인터페이스를 구현한 객체를 제공
    // @Unsecured 어노테이션이 붙은 Retrofit 객체를 사용
    // provideLoginApi 사용되는 곳은 viewModel, repository 등 필요한 곳
    fun provideNurseAuthApi(@Unsecured retrofit: Retrofit): NurseAuthService = retrofit.create()
}