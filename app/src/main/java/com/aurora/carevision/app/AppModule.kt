package com.aurora.carevision.app

import android.content.Context
import android.content.SharedPreferences
import com.aurora.carevision.data.local.auth.TokenProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // 앱 전역에 사용되는 객체를 제공
    // 앱 전역에 사용되는 객체는 AppModule에 제공
    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideTokenProvider(sharedPreferences: SharedPreferences): TokenProvider {
        return TokenProvider(sharedPreferences)
    }
}
