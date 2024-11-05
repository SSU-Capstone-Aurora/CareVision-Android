package com.aurora.carevision.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.aurora.carevision.feature.admin.auth.login.adminLoginScreen
import com.aurora.carevision.feature.admin.auth.login.navigateToAdminLogin
import com.aurora.carevision.feature.admin.auth.signup.adminSignUpScreen
import com.aurora.carevision.feature.admin.home.navigation.adminHomeScreen
import com.aurora.carevision.feature.admin.home.navigation.navigateToAdminHome
import com.aurora.carevision.feature.intro.Intro
import com.aurora.carevision.feature.intro.initialLoginScreen
import com.aurora.carevision.feature.intro.navigateToIntro
import com.aurora.carevision.feature.nurse.auth.login.navigateToNurseLogin
import com.aurora.carevision.feature.nurse.auth.login.nurseLoginScreen
import com.aurora.carevision.feature.nurse.auth.signup.NurseSignUpViewModel
import com.aurora.carevision.feature.nurse.auth.signup.navigateToNurseSignUpHospital
import com.aurora.carevision.feature.nurse.auth.signup.navigationToNurseSignupIdPw
import com.aurora.carevision.feature.nurse.auth.signup.navigationToNurseSignupName
import com.aurora.carevision.feature.nurse.auth.signup.navigationToNurseSignupWaiting
import com.aurora.carevision.feature.nurse.auth.signup.nurseSignUpHospitalScreen
import com.aurora.carevision.feature.nurse.home.navigation.navigateToNurseHome
import com.aurora.carevision.feature.nurse.home.navigation.nurseHomeScreen

@Composable
fun CVNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: Any = Intro,
) {
    val nurseSignUpViewModel: NurseSignUpViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        initialLoginScreen(
            navigateToLogin = { navController.navigateToNurseLogin() },
            navigateToSignUp = { navController.navigateToNurseSignUpHospital() },
            navigateToAdminLogin = { navController.navigateToAdminLogin() }
        )

        nurseLoginScreen(
            navigateToHome = { navController.navigateToNurseHome() },
            navigateToSignUp = { navController.navigateToNurseSignUpHospital() },
            navigateToBack = { navController.popBackStack() }
        )

        nurseSignUpHospitalScreen(
            viewModel = nurseSignUpViewModel,  // Pass shared ViewModel
            navigateToIntro = { navController.navigateToIntro() },
            navigateToNurseSignUpHospital = { navController.navigateToNurseSignUpHospital() },
            navigateToNurseSignUpName = { navController.navigationToNurseSignupName() },
            navigateToNurseSignUpIdPw = { navController.navigationToNurseSignupIdPw() },
            navigateToNurseSignUpWaiting = { navController.navigationToNurseSignupWaiting() },
            navigateToHome = { navController.navigateToNurseHome() },
            navigateToBack = { navController.popBackStack() }
        )

        nurseHomeScreen(
            navigateToNurseLogin = { navController.navigateToIntro() },
        )

        adminLoginScreen(
            navigateToHome = { navController.navigateToAdminHome() },
            navigateToSignUp = { navController.navigateToNurseSignUpHospital() }
        )

        adminSignUpScreen(
            navigateToHome = { navController.navigateToAdminHome() }
        )

        adminHomeScreen()
    }
}
