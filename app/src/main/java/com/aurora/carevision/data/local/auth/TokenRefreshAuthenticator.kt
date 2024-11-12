package com.aurora.carevision.data.local.auth

import com.aurora.carevision.data.remote.auth.service.NurseAuthService
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenRefreshAuthenticator @Inject constructor( // TODO
    private val tokenProvider: TokenProvider, // 액세스 및 리프레시 토큰을 관리하는 클래스
    private val nurseAuthService: NurseAuthService // 리프레시 토큰으로 새로운 액세스 토큰을 발급하는 API 서비스
) : Authenticator {
    // 인증이 실패하면 자동으로 리프레시 토큰을 사용하여 새로운 액세스 토큰을 요청하고, 원래 요청을 다시 시도하는 역할
    override fun authenticate(route: Route?, response: Response): Request? {
//        // 응답이 401 Unauthorized 인 경우에만 실행
//        val refreshToken = tokenProvider.getRefreshToken() ?: return null
//
//        // 새로운 액세스 토큰 요청
//        val newAccessToken = nurseAuthService.refreshToken(refreshToken).execute().body()?.accessToken
//
//        // 새로운 액세스 토큰을 받지 못하면 null 반환
//        if (newAccessToken.isNullOrEmpty()) return null
//
//        // 새로 받은 액세스 토큰을 저장
//        tokenProvider.saveAccessToken(newAccessToken)
//
//        // 원래 요청을 새로운 액세스 토큰으로 재시도
//        return response.request.newBuilder()
//            .header("Authorization", "Bearer $newAccessToken")
//            .build()
        return null
    }
}