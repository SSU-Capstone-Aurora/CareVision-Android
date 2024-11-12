package com.aurora.carevision.core.network.di

import com.aurora.carevision.BuildConfig
import com.aurora.carevision.core.network.auth.AuthInterceptor
import com.aurora.carevision.core.network.auth.TokenRefreshAuthenticator
import com.aurora.carevision.core.network.qualifier.Secured
import com.aurora.carevision.core.network.qualifier.Unsecured
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter

@Module // Dagger 모듈
@InstallIn(SingletonComponent::class) // 어플리케이션 전역에 사용되는 객체
object NetworkModule {
    // 네트워크 모듈은 Retrofit, OkHttpClient, Json, ConverterFactory, LoggingInterceptor를 제공

    private const val BASE_URL = BuildConfig.CV_BASE_URL_DEV

    @Provides
    @Singleton
    // Json 객체를 제공
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true // 알 수 없는 키를 무시
        coerceInputValues = true // 입력 값을 강제로 변환
    }

    @Provides
    @Singleton
    // Json 객체를 ConverterFactory로 변환
    // ConverterFactory는 서버로부터 받은 JSON 데이터를 객체로 변환하는 역할
    fun provideJsonConverterFactory(json: Json): Converter.Factory {
        return json.asConverterFactory("application/json".toMediaType())
    }

    @Provides
    @Singleton
    // 로깅 인터셉터를 제공
    // 로깅 인터셉터는 네트워크 요청과 응답을 로그로 출력
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        // 디버그 모드일 때만 로그 출력
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    @Provides
    @Singleton
    @Secured
    // 인증이 필요한 OkHttpClient를 제공 (로그인이 필요한 경우)
    fun provideSecuredOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor, // 인증이 필요한 경우 Authorization 헤더 추가
        authenticator: TokenRefreshAuthenticator // 인증이 실패한 경우 자동으로 재인증
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(authInterceptor) // 인증이 필요한 경우 Authorization 헤더 추가
        .authenticator(authenticator) // 인증이 필요한 경우 자동으로 재인증(refresh token 요청)
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    @Unsecured
    // 인증이 필요하지 않은 OkHttpClient를 제공 (로그인이 필요하지 않은 경우 - 로그인, 회원가입 내 api 등)
    fun provideUnsecuredOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    @Secured
    // 인증이 필요한 Retrofit을 제공
    fun provideSecuredRetrofit(
        @Secured client: OkHttpClient,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(provideJsonConverterFactory(provideJson()))
        .build()

    @Provides
    @Singleton
    @Unsecured
    // 인증이 필요하지 않은 Retrofit을 제공
    fun provideUnsecuredRetrofit(
        @Unsecured client: OkHttpClient,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(provideJsonConverterFactory(provideJson()))
        .build()
}