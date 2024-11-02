package com.aurora.carevision.feature.nurse.auth.signup

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aurora.carevision.feature.nurse.auth.signup.select_hospital.NurseSignUpScreen
import kotlinx.serialization.Serializable

@Serializable
data object NurseSignUp

fun NavController.navigateToNurseSignUp(navOptions: NavOptions? = null) = navigate(NurseSignUp, navOptions)

fun NavGraphBuilder.nurseSignUpScreen(
    navigateToHome: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable<NurseSignUp> {
        NurseSignUpScreen(
            //onSignUpClick = navigateToHome,
            navigateToBack = navigateToBack,
        )
    }
}