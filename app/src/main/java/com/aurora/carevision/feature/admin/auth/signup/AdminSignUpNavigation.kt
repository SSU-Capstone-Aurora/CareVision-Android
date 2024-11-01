package com.aurora.carevision.feature.admin.auth.signup

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object AdminSignUp

fun NavController.navigateToAdminSignUp(navOptions: NavOptions? = null) = navigate(AdminSignUp, navOptions)

fun NavGraphBuilder.adminSignUpScreen(
    navigateToHome: () -> Unit,
) {
    composable<AdminSignUp> {
        AdminSignUpHospitalEntryScreen(
            //onSignUpClick = navigateToHome,
        )
    }
}