package com.aurora.carevision.data.remote.nurse.fcm.di

import android.content.Context
import com.aurora.carevision.core.network.qualifier.Secured
import com.aurora.carevision.core.network.qualifier.Unsecured
import com.aurora.carevision.data.remote.nurse.auth.service.NurseAuthService
import com.aurora.carevision.data.remote.nurse.fcm.service.AppFirebaseMessagingService
import com.aurora.carevision.data.remote.nurse.fcm.service.FirebaseTokenService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FCMModule {
    // fcm token 서비스를 제공
    @Provides
    @Singleton
    fun provideFirebaseTokenService(@Secured retrofit: Retrofit): FirebaseTokenService = retrofit.create()

    @Provides
    @Singleton
    fun provideAppFirebaseMessagingService(
        context: Context
    ): AppFirebaseMessagingService = AppFirebaseMessagingService()
}