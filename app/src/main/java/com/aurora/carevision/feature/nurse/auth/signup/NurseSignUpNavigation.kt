package com.aurora.carevision.feature.nurse.auth.signup

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aurora.carevision.feature.nurse.auth.signup.done.NurseSignUpWaitingScreen
import com.aurora.carevision.feature.nurse.auth.signup.info.NurseSignUpIdPwScreen
import com.aurora.carevision.feature.nurse.auth.signup.info.NurseSignUpNameScreen
import com.aurora.carevision.feature.nurse.auth.signup.select_hospital.NurseSignUpScreen
import kotlinx.serialization.Serializable

@Serializable
data object NurseSignUp

@Serializable
data object NurseSignUpName

@Serializable
data object NurseSignUpIdPw

@Serializable
data object NurseSignUpWaiting

fun NavController.navigateToNurseSignUpHospital(navOptions: NavOptions? = null) = navigate(NurseSignUp, navOptions)
fun NavController.navigationToNurseSignupName(navOptions: NavOptions? = null) = navigate(NurseSignUpName, navOptions)
fun NavController.navigationToNurseSignupIdPw(navOptions: NavOptions? = null) = navigate(NurseSignUpIdPw, navOptions)
fun NavController.navigationToNurseSignupWaiting(navOptions: NavOptions? = null) = navigate(NurseSignUpWaiting, navOptions)

fun NavGraphBuilder.nurseSignUpHospitalScreen(
    viewModel: NurseSignUpViewModel,
    navigateToIntro: () -> Unit,
    navigateToNurseSignUpHospital: () -> Unit,
    navigateToNurseSignUpName: () -> Unit,
    navigateToNurseSignUpIdPw: () -> Unit,
    navigateToNurseSignUpWaiting: () -> Unit,
    navigateToHome: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable<NurseSignUp> {
        NurseSignUpScreen(
            navigateToBack = navigateToIntro,
            navigateToSignUpNameScreen = navigateToNurseSignUpName,
            viewModel = viewModel
        )
    }

    composable<NurseSignUpName> {
        NurseSignUpNameScreen(
            navigateToBack = navigateToNurseSignUpHospital,
            navigateToSignUpIdPwScreen = navigateToNurseSignUpIdPw,
            viewModel = viewModel
        )
    }

    composable<NurseSignUpIdPw> {
        NurseSignUpIdPwScreen(
            navigateToBack = navigateToNurseSignUpName,
            navigateToSignUpWaitingScreen = navigateToNurseSignUpWaiting,
            viewModel = viewModel
        )
    }

    composable<NurseSignUpWaiting> {
        NurseSignUpWaitingScreen(
            navigateToHome = navigateToHome,
            //viewModel = viewModel
        )
    }
}