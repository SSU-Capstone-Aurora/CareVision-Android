package com.aurora.carevision.data.remote.nurse.mypage.di

import com.aurora.carevision.data.remote.nurse.mypage.datasource.DefaultNurseMypageDataSource
import com.aurora.carevision.data.remote.nurse.mypage.datasource.NurseMypageRemoteDataSource
import com.aurora.carevision.data.remote.nurse.mypage.repository.DefaultNurseMypageRepository
import com.aurora.carevision.domain.nurse.repository.NurseMypageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NurseMypageRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRemoteNurseMypageDataSource(
        defaultNurseMypageDataSource: DefaultNurseMypageDataSource
    ): NurseMypageRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindNurseMypageMypageRepository(
        defaultNurseMypageRepository: DefaultNurseMypageRepository
    ): NurseMypageRepository
}
