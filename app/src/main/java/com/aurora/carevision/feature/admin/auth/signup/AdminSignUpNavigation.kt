package com.aurora.carevision.feature.admin.auth.signup

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aurora.carevision.feature.admin.auth.signup.done.AdminSignUpCompletionScreen
import com.aurora.carevision.feature.admin.auth.signup.info.AdminIDPasswordInfoRoute
import com.aurora.carevision.feature.admin.auth.signup.info.AdminNameInfoRoute
import com.aurora.carevision.feature.admin.auth.signup.select_hospital.AdminSignUpHospitalEntryScreen
import kotlinx.serialization.Serializable

@Serializable
data object AdminSignUp

@Serializable
data object AdminSignUpName

@Serializable
data object AdminSignUpIdPw

@Serializable
data object AdminSignUpWaiting

fun NavController.navigateToAdminSignUp(navOptions: NavOptions? = null) = navigate(AdminSignUp, navOptions)
fun NavController.navigationToAdminSignUpName(navOptions: NavOptions? = null) = navigate(AdminSignUpName, navOptions)
fun NavController.navigationToAdminSignUpIdPw(navOptions: NavOptions? = null) = navigate(AdminSignUpIdPw, navOptions)
fun NavController.navigationToAdminSignupWaiting(navOptions: NavOptions? = null) = navigate(AdminSignUpWaiting, navOptions)


fun NavGraphBuilder.adminSignUpHospitalScreen(
    viewModel: AdminSignUpHospitalEntryViewModel,
    navigateToIntro: () -> Unit,
    navigateToAdminSignUpHospital: () -> Unit,
    navigateToAdminSignUpName: () -> Unit,
    navigateToAdminSignUpIdPw: () -> Unit,
    navigateToAdminLogin: () ->Unit,
    navigateToHome: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable<AdminSignUp> {
        AdminSignUpHospitalEntryScreen(
            navigateToBack = navigateToIntro,
            navigateToSignUpNameScreen = navigateToAdminSignUpName,
            viewModel = viewModel

        )
    }
    composable<AdminSignUpName> {
        AdminNameInfoRoute(
            navigateToBack = navigateToAdminSignUpHospital,
            navigateToSignUpIdPwScreen = navigateToAdminSignUpIdPw,
            viewModel = viewModel
        )
    }
    composable<AdminSignUpIdPw> {
        AdminIDPasswordInfoRoute(
            navigateToBack = navigateToAdminSignUpName,
            navigateToAdminLogin =navigateToAdminLogin,
            viewModel = viewModel
            )
    }
    composable<AdminSignUpWaiting> {
        AdminSignUpCompletionScreen(
            navigateToHome = navigateToHome,
            viewModel = viewModel
        )
    }
}

