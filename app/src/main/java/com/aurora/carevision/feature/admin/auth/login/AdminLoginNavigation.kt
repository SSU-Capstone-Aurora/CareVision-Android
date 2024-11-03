package com.aurora.carevision.feature.admin.auth.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object AdminLogin

fun NavHostController.navigateToAdminLogin(navOptions: NavOptions? = null) = navigate(AdminLogin, navOptions)

fun NavGraphBuilder.adminLoginScreen(
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToBack:() -> Unit
) {
    composable<AdminLogin> {
        AdminLoginScreen(
            navigateToHome = navigateToHome,
            navigateToSignUp = navigateToSignUp,
            navigateToBack = navigateToBack,
        )
    }
}