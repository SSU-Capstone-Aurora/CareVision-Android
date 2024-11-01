package com.aurora.carevision.feature.intro

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

// Intro 화면을 나타내는 Intro 클래스를 선언, Route로 사용
@Serializable
data object Intro

// 외부에서 Intro로 이동할 수 있도록 NavHostController에 navigateToIntro 함수를 추가
fun NavHostController.navigateToIntro(navOptions: NavOptions) = navigate(Intro, navOptions)

// Intro 화면을 그리는 composable 함수를 NavGraphBuilder에 추가
fun NavGraphBuilder.initialLoginScreen(
    navigateToLogin: () -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToAdminLogin: () -> Unit,
) {
    composable<Intro> {
        InitialLoginScreen(
            onLoginClick = navigateToLogin,
            onSignUpClick = navigateToSignUp,
            onAdminLoginClick = navigateToAdminLogin,
        )
    }
}