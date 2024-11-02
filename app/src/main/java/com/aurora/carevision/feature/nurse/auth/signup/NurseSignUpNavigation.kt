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

fun NavController.navigateToNurseSignUpHospital(navOptions: NavOptions? = null) = navigate(NurseSignUp, navOptions)
fun NavController.navigationToNurseSignupName(navOptions: NavOptions? = null) = navigate(NurseSignUp, navOptions)
fun NavController.navigationToNurseSignupIdPw(navOptions: NavOptions? = null) = navigate(NurseSignUp, navOptions)
fun NavController.navigationToNurseSignupWaiting(navOptions: NavOptions? = null) = navigate(NurseSignUp, navOptions)

fun NavGraphBuilder.nurseSignUpHospitalScreen(
    navigateToNurseSignUpName: () -> Unit,
    navigateToNurseSignUpIdPw: () -> Unit,
    navigateToNurseSignUpWaiting: () -> Unit,
    navigateToHome: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable<NurseSignUp> {
        NurseSignUpScreen(
            navigateToBack = navigateToBack,
            navigateToNext = navigateToNurseSignUpName,
        )
    }

    composable<NurseSignUp> {
        NurseSignUpNameScreen(
            navigateToBack = navigateToBack,
            navigateToNext = navigateToNurseSignUpIdPw,
        )
    }

    composable<NurseSignUp> {
        NurseSignUpIdPwScreen(
            navigateToBack = navigateToBack,
            navigateToNext = navigateToNurseSignUpWaiting,
        )
    }

    composable<NurseSignUp> {
        NurseSignUpIdPwScreen(
            navigateToBack = navigateToBack,
            navigateToNext = navigateToNurseSignUpWaiting,
        )
    }

    composable<NurseSignUp> {
        NurseSignUpWaitingScreen(
            navigateToHome = navigateToHome
        )
    }
}