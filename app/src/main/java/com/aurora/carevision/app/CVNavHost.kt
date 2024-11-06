package com.aurora.carevision.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminBottomBar
import com.aurora.carevision.core.component.NurseBottomBar
import com.aurora.carevision.feature.admin.auth.login.adminLoginScreen
import com.aurora.carevision.feature.admin.auth.login.navigateToAdminLogin
import com.aurora.carevision.feature.admin.auth.signup.adminSignUpScreen
import com.aurora.carevision.feature.admin.home.navigation.AdminHome
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
import com.aurora.carevision.feature.nurse.home.navigation.NurseHome
import com.aurora.carevision.feature.nurse.home.navigation.navigateToNurseHome
import com.aurora.carevision.feature.nurse.home.navigation.nurseHomeScreen
import com.aurora.carevision.feature.nurse.mypage.NurseMypage
import com.aurora.carevision.feature.nurse.mypage.navigateToNurseMypage
import com.aurora.carevision.feature.nurse.mypage.nurseMypageScreen
import com.aurora.carevision.feature.nurse.patient.info.PatientInfo
import com.aurora.carevision.feature.nurse.patient.info.navigateToPatientInfo
import com.aurora.carevision.feature.nurse.patient.info.patientInfoScreen
import com.aurora.carevision.feature.nurse.patient.registration.PatientRegistration
import com.aurora.carevision.feature.nurse.patient.registration.navigateToPatientRegistration
import com.aurora.carevision.feature.nurse.patient.registration.patientRegistrationScreen

@Composable
fun CVNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: Any = Intro,
) {
    val nurseSignUpViewModel: NurseSignUpViewModel = hiltViewModel()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .statusBarsPadding()
            .systemBarsPadding(),

        bottomBar = {
            if (isNurseBottomNaviScreen(currentRoute)) {
                CVNurseBottomBar(navController)
            }
            if (currentRoute == AdminHome.javaClass.name) {
                AdminBottomBar(
                    navigateToHome = { navController.navigate("home") },
                    navigateToPatientRegister = { navController.navigate("patient_register") },
                )
            }
        }
    ) { innerPadding ->
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

            nurseMypageScreen()

            patientInfoScreen()

            patientRegistrationScreen()

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
}

@Composable
private fun isNurseBottomNaviScreen(currentRoute: String?): Boolean =
    currentRoute == NurseHome.javaClass.name || currentRoute == NurseMypage.javaClass.name || currentRoute == PatientInfo.javaClass.name || currentRoute == PatientRegistration.javaClass.name

@Composable
private fun CVNurseBottomBar(navController: NavHostController) {
    NurseBottomBar(
        navigateToHome = {
            navController.navigateToNurseHome(
                navOptions {
                    bottomNavOptions(navController)
                }
            )
        },
        navigateToPatientInfo = {
            navController.navigateToPatientInfo(
                navOptions {
                    bottomNavOptions(navController)
                }
            )
        },
        navigateToPatientRegister = {
            navController.navigateToPatientRegistration(
                navOptions {
                    bottomNavOptions(navController)
                }
            )
        },
        navigateToMypage = {
            navController.navigateToNurseMypage(
                navOptions {
                    bottomNavOptions(navController)
                }
            )
        }
    )
}

private fun NavOptionsBuilder.bottomNavOptions(navController: NavHostController) {
    popUpTo(navController.graph.findStartDestination().id) {
        saveState = true
    }
    launchSingleTop = true
    restoreState = false
}
