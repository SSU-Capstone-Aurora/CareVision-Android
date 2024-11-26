package com.aurora.carevision.data.remote.admin.nurserequest.di

import com.aurora.carevision.data.remote.admin.nurserequest.datasource.DefaultAdminNurseRequestDataSource
import com.aurora.carevision.data.remote.admin.nurserequest.datasource.AdminNurseRequestDataSource
import com.aurora.carevision.data.remote.admin.nurserequest.repository.DefaultAdminNurseRequestRepository
import com.aurora.carevision.data.remote.admin.nurserequest.service.AdminNurseRequestService
import com.aurora.carevision.domain.admin.repository.AdminNurseRequestRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AdminNurseRequestRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAdminNurseRequestRemoteDataSource(
        defaultAdminNurseRequestDataSource: DefaultAdminNurseRequestDataSource
    ): AdminNurseRequestDataSource

    @Binds
    @Singleton
    abstract fun bindAdminNurseRequestRepository(
        defaultAdminNurseRequestRepository: DefaultAdminNurseRequestRepository
    ): AdminNurseRequestRepository
}