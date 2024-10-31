package com.aurora.carevision.feature.intro

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object Intro

fun NavHostController.navigateToIntro(navOptions: NavOptions) = navigate(Intro, navOptions)

fun NavGraphBuilder.introScreen(
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