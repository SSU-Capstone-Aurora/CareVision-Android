package com.aurora.carevision.data.local.auth

import okhttp3.Interceptor
import okhttp3.Response

// API 요청 시 Authorization 헤더에 Bearer 토큰을 추가하는 인터셉터 클래스
class AuthInterceptor(private val tokenProvider: () -> String?) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = tokenProvider()
        val requestBuilder = chain.request().newBuilder()

        if (token != null) {
            // 인증이 필요한 경우에만 Authorization 헤더 추가
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(requestBuilder.build())
    }
}