package com.aurora.carevision.feature.nurse.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aurora.carevision.feature.nurse.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object NurseHome

fun NavController.navigateToNurseHome(navOptions: NavOptions? = null) = navigate(NurseHome, navOptions)

fun NavGraphBuilder.nurseHomeScreen(
    navigateToNurseLogin: () -> Unit,
    navigateToNurseSignUp: () -> Unit,
) {
    composable<NurseHome> {
        HomeScreen(
            //
        )
    }
}