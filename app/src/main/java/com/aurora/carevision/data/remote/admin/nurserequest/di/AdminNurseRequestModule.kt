package com.aurora.carevision.data.remote.admin.nurserequest.di

import com.aurora.carevision.core.network.qualifier.Secured
import com.aurora.carevision.core.network.qualifier.Unsecured
import com.aurora.carevision.data.remote.admin.nurserequest.service.AdminNurseRequestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AdminNurseRequestModule {
    @Provides
    @Singleton
    fun provideAdminNurseRequestApi(@Secured retrofit: Retrofit): AdminNurseRequestService = retrofit.create()
}