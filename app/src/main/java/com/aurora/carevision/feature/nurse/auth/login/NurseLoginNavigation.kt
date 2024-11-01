package com.aurora.carevision.feature.nurse.auth.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object NurseLogin

fun NavHostController.navigateToNurseLogin(navOptions: NavOptions? = null) = navigate(NurseLogin, navOptions)

fun NavGraphBuilder.nurseLoginScreen(
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable<NurseLogin> {
        NurseLoginScreen(
            navigateToHome = navigateToHome,
            navigateToSignUp = navigateToSignUp,
            navigateToBack = navigateToBack,
        )
    }
}