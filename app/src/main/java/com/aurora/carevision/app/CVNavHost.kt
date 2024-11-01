package com.aurora.carevision.navigation

import androidx.compose.runtime.Composable
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
import com.aurora.carevision.feature.nurse.auth.login.navigateToNurseLogin
import com.aurora.carevision.feature.nurse.auth.login.nurseLoginScreen
import com.aurora.carevision.feature.nurse.auth.signup.navigateToNurseSignUp
import com.aurora.carevision.feature.nurse.auth.signup.nurseSignUpScreen
import com.aurora.carevision.feature.nurse.home.navigation.navigateToNurseHome

@Composable
fun CVNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: Any = Intro,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        initialLoginScreen(
            navigateToLogin = { navController.navigateToNurseLogin() },
            navigateToSignUp = { navController.navigateToNurseSignUp() },
            navigateToAdminLogin = { navController.navigateToAdminLogin() }
        )

        nurseLoginScreen(
            //navigateToHome = { navController.navigateToNurseHome() },
            //navigateToSignUp = { navController.navigateToNurseSignUp() },
            navigateToBack = { navController.popBackStack() }
        )

        nurseSignUpScreen(
            navigateToHome = { navController.navigateToNurseHome() },
            navigateToBack = { navController.popBackStack() }
        )

        adminLoginScreen(
            navigateToHome = { navController.navigateToAdminHome() },
            navigateToSignUp = { navController.navigateToNurseSignUp() }
        )

        adminSignUpScreen(
            navigateToHome = { navController.navigateToAdminHome() }
        )

        adminHomeScreen()
    }
}
