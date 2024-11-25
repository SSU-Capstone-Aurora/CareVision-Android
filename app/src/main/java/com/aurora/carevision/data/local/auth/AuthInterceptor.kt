package com.aurora.carevision.data.local.auth

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

// API 요청 시 Authorization 헤더에 Bearer 토큰을 추가하는 인터셉터 클래스
class AuthInterceptor @Inject constructor(
    private val tokenProvider: TokenProvider,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val accessToken = tokenProvider.getAccessToken()
        val request = chain.request().newBuilder()
            .apply {
                if (!accessToken.isNullOrEmpty()) {
                    addHeader("Authorization", "Bearer $accessToken")
                }
            }
            .build()
        return chain.proceed(request)
    }
}