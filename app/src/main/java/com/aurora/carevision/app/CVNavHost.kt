package com.aurora.carevision.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.aurora.carevision.app.adminTopLevelRoutes
import com.aurora.carevision.app.topLevelRoutes
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.AdminBottomBar
import com.aurora.carevision.core.component.AdminBottomNavItem
import com.aurora.carevision.core.component.BottomNavItem
import com.aurora.carevision.core.component.CVAdminRegistrationModal
import com.aurora.carevision.core.component.NurseBottomBar
import com.aurora.carevision.feature.admin.auth.login.adminLoginScreen
import com.aurora.carevision.feature.admin.auth.login.navigateToAdminLogin
import com.aurora.carevision.feature.admin.auth.signup.AdminSignUpHospitalEntryViewModel
import com.aurora.carevision.feature.admin.auth.signup.navigateToAdminSignUp
import com.aurora.carevision.feature.admin.auth.signup.navigationToAdminSignUpIdPw
import com.aurora.carevision.feature.admin.auth.signup.navigationToAdminSignUpName
import com.aurora.carevision.feature.admin.auth.signup.adminSignUpHospitalScreen
import com.aurora.carevision.feature.admin.home.navigation.AdminHome
import com.aurora.carevision.feature.admin.home.navigation.adminHomeScreen
import com.aurora.carevision.feature.admin.home.navigation.navigateToAdminHome
import com.aurora.carevision.feature.admin.registration.camera.CameraRegistrationViewModel
import com.aurora.carevision.feature.admin.registration.camera.cameraRegistrationScreen
import com.aurora.carevision.feature.admin.registration.camera.navigateToCameraRegistAfterBarCode
import com.aurora.carevision.feature.admin.registration.camera.navigateToCameraRegistFinish
import com.aurora.carevision.feature.admin.registration.camera.navigateToCameraRegistrationInfo
import com.aurora.carevision.feature.admin.registration.patient.adminPatientRegistrationScreen
import com.aurora.carevision.feature.admin.registration.patient.navigateToAdminCameraListInfo
import com.aurora.carevision.feature.admin.registration.patient.navigateToAdminCheckPatientName
import com.aurora.carevision.feature.admin.registration.patient.navigateToAdminCheckTotalInfo
import com.aurora.carevision.feature.admin.registration.patient.navigateToAdminPatientRegistrationDone
import com.aurora.carevision.feature.admin.registration.patient.navigateToEnterAdminPatientNumber
import com.aurora.carevision.feature.admin.request.AdminRequestAcceptance
import com.aurora.carevision.feature.admin.request.adminRequestAcceptanceScreen
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
import com.aurora.carevision.feature.nurse.auth.signup.nurseSignUpScreen
import com.aurora.carevision.feature.nurse.home.home.HomeViewModel
import com.aurora.carevision.feature.nurse.home.navigation.NurseHome
import com.aurora.carevision.feature.nurse.home.navigation.navigateToNurseHome
import com.aurora.carevision.feature.nurse.home.navigation.navigateToNurseSavedVideo
import com.aurora.carevision.feature.nurse.home.navigation.navigateToNurseStreaming
import com.aurora.carevision.feature.nurse.home.navigation.nurseHomeScreen
import com.aurora.carevision.feature.nurse.mypage.NurseMypage
import com.aurora.carevision.feature.nurse.mypage.nurseMypageScreen
import com.aurora.carevision.feature.nurse.patient.info.PatientInfo
import com.aurora.carevision.feature.nurse.patient.info.navigateToPatientInfo
import com.aurora.carevision.feature.nurse.patient.info.patientInfoScreen
import com.aurora.carevision.feature.nurse.patient.registration.barcode.SelfRegistrationViewModel
import com.aurora.carevision.feature.nurse.patient.registration.navigateToCameraListInfo
import com.aurora.carevision.feature.nurse.patient.registration.navigateToCheckTotalInfo
import com.aurora.carevision.feature.nurse.patient.registration.navigateToCheckPatientName
import com.aurora.carevision.feature.nurse.patient.registration.navigateToPatientRegistration
import com.aurora.carevision.feature.nurse.patient.registration.navigateToPatientRegistrationDone
import com.aurora.carevision.feature.nurse.patient.registration.navigateToScanningBarcode
import com.aurora.carevision.feature.nurse.patient.registration.patientRegistrationScreen
import com.aurora.carevision.feature.nurse.patient.registration.search.PatientRegistrationViewModel


@Composable
fun CVNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: Any = Intro,
) {
    val nurseSignUpViewModel: NurseSignUpViewModel = hiltViewModel()
    val adminSignUpViewModel: AdminSignUpHospitalEntryViewModel = hiltViewModel()
    val selfRegistrationViewModel: SelfRegistrationViewModel = hiltViewModel()
    val cameraRegistrationViewModel : CameraRegistrationViewModel = hiltViewModel()
    val patientRegistrationViewModel: PatientRegistrationViewModel = hiltViewModel()
    val homeViewModel: HomeViewModel = hiltViewModel()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    var isModalVisible by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .statusBarsPadding()
            .systemBarsPadding(),

        bottomBar = {
            if (isNurseBottomNaviScreen(currentRoute)) {
                NurseBottomBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    topLevelRoutes.forEach { topLevelRoute ->
                        BottomNavItem(
                            icon = topLevelRoute.defaultIcon,
                            label = topLevelRoute.name,
                            isSelected = currentDestination?.hierarchy?.any {
                                it.route == topLevelRoute.route.javaClass.name
                            } == true,
                            onClick = {
                                navController.navigate(topLevelRoute.route) {
                                    bottomNavOptions(navController)
                                }
                            }
                        )
                    }
                }
            }
            // AdminBottomBar 관련 코드 추가
                else if (isAdminBottomNaviScreen(currentRoute)) {
                    AdminBottomBar (
                        onCenterButtonClick = {isModalVisible = true}
                    ){
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        adminTopLevelRoutes.forEach { topLevelRoute ->
                            AdminBottomNavItem(
                                icon = topLevelRoute.defaultIcon,
                                label = topLevelRoute.name,
                                isSelected = currentDestination?.hierarchy?.any {
                                    it.route == topLevelRoute.route.javaClass.name
                                } == true,
                                onClick = {
                                    navController.navigate(topLevelRoute.route) {
                                        bottomNavOptions(navController)
                                    }
                                }
                            )
                        }
                    }
                CVAdminRegistrationModal(
                    isVisible = isModalVisible,
                    onDismiss = { isModalVisible = false },
                    onDeviceRegistrationClick = {
                        isModalVisible = false
                        navController.navigateToCameraRegistAfterBarCode()
                    },
                    onPatientRegistrationClick = {
                        isModalVisible = false
                        navController.navigateToEnterAdminPatientNumber()
                    }
                )
                }
            //}
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding) // innerPadding 오류로 임시 추가
        ) {
            initialLoginScreen(
                navigateToLogin = { navController.navigateToNurseLogin() },
                navigateToSignUp = { navController.navigateToNurseSignUpHospital() },
                navigateToAdminLogin = { navController.navigateToAdminLogin() }
            )

            nurseLoginScreen(
                navigateToHome = {
                    navController.navigateToNurseHome(
                        navOptions {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                            }
                            launchSingleTop = true
                            restoreState = false
                        }
                    )
                },
                navigateToSignUp = { navController.navigateToNurseSignUpHospital() },
                navigateToBack = { navController.popBackStack() }
            )

            nurseSignUpScreen(
                viewModel = nurseSignUpViewModel,  // Pass shared ViewModel TODO Refactoring
                navigateToIntro = { navController.navigateToIntro() },
                navigateToNurseSignUpHospital = { navController.navigateToNurseSignUpHospital() },
                navigateToNurseSignUpName = { navController.navigationToNurseSignupName() },
                navigateToNurseSignUpIdPw = { navController.navigationToNurseSignupIdPw() },
                navigateToNurseSignUpWaiting = { navController.navigationToNurseSignupWaiting() },
                navigateToHome = {
                    navController.navigateToNurseHome(
                        navOptions {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                            }
                            launchSingleTop = true
                            restoreState = false
                        }
                    )
                },
                navigateToLogin = { navController.navigateToNurseLogin() },
                navigateToBack = { navController.popBackStack() }
            )

            nurseHomeScreen(
                navigateToSpecificPatientStreamingScreen = { navController.navigateToNurseStreaming() },
                navigateToSavedVideoScreen = { navController.navigateToNurseSavedVideo() },
                onBackClick = { navController.popBackStack() },
                viewModel = homeViewModel
            )

            nurseMypageScreen(
                navigateToNurseLogin = { navController.navigateToIntro() }
            )

            patientInfoScreen(
                navigateToPatientRegistration = { navController.navigateToPatientRegistration() }
            )

            patientRegistrationScreen(
                selfRegistrationViewModel = selfRegistrationViewModel,
                registrationViewModel = patientRegistrationViewModel,
                navigateToPatientRegistrationDone = { navController.navigateToPatientRegistrationDone() },
                navigateToPatientInfo = { navController.navigateToPatientInfo() },
                navigateToPatientRegistration = { navController.navigateToPatientInfo() },
                navigateToCheckPatientName = { navController.navigateToCheckPatientName() },
                navigateToCameraListInfo = { navController.navigateToCameraListInfo() },
                navigateToCheckTotalInfo = { navController.navigateToCheckTotalInfo() },
                navigateToScanningBarcode = { navController.navigateToScanningBarcode() },
                navController = navController,
                onClickBack = { navController.popBackStack() }
            )

            adminLoginScreen(
                navigateToHome = {
                    navController.navigateToAdminHome(
                        navOptions {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                            }
                            launchSingleTop = true
                            restoreState = false
                        }
                    )
                },
                navigateToSignUp = { navController.navigateToAdminSignUp() },
                navigateToBack = { navController.popBackStack() }
            )

            adminSignUpHospitalScreen(
                viewModel = adminSignUpViewModel,
                navigateToIntro = { navController.navigateToIntro() },
                navigateToAdminSignUpHospital = { navController.navigateToAdminSignUp() },
                navigateToAdminSignUpName = { navController.navigationToAdminSignUpName() },
                navigateToAdminSignUpIdPw = { navController.navigationToAdminSignUpIdPw() },
                navigateToAdminLogin = {navController.navigateToAdminLogin()},
                navigateToHome = {
                    navController.navigateToAdminHome(navOptions {
                        popUpTo(navController.graph.findStartDestination().id) { inclusive = true }
                        launchSingleTop = true
                    })
                },
                navigateToBack = { navController.popBackStack() }
            )

            adminHomeScreen(
                navigateToAdminLogin = {navController.navigateToIntro()}
            )
            adminRequestAcceptanceScreen(
                navigateToBack = { navController.popBackStack() }
            )

            adminPatientRegistrationScreen(
                navigateToAdminPatientRegistrationDone = { navController.navigateToAdminPatientRegistrationDone() },
                navigateToEnterAdminPatientNumber = { navController.navigateToEnterAdminPatientNumber() },
                navigateToAdminCheckPatientName = { navController.navigateToAdminCheckPatientName() },
                navigateToAdminCameraListInfo = { navController.navigateToAdminCameraListInfo() },
                navigateToAdminCheckTotalInfo = {navController.navigateToAdminCheckTotalInfo()},
                navigateToAdminHome = {navController.navigateToAdminHome()},
                onClickBack = { navController.popBackStack() }
            )
            cameraRegistrationScreen(
                viewModel = CameraRegistrationViewModel(),
                navigateToCameraRegistrationInfo = {navController.navigateToCameraRegistrationInfo()},
                navigateToCameraRegistFinish = {navController.navigateToCameraRegistFinish()},
                onFinish = {navController.navigateToAdminHome()},
                navigateToBack = {navController.popBackStack()},
            )
        }
    }
}


@Composable
private fun isNurseBottomNaviScreen(currentRoute: String?): Boolean =
    currentRoute == NurseHome.javaClass.name || currentRoute == NurseMypage.javaClass.name || currentRoute == PatientInfo.javaClass.name

private fun NavOptionsBuilder.bottomNavOptions(navController: NavHostController) {
    popUpTo(navController.graph.id) {
        inclusive = true
    }
    launchSingleTop = true
    restoreState = false
}

@Composable
private fun isAdminBottomNaviScreen(currentRoute: String?): Boolean =
    currentRoute == AdminHome.javaClass.name || currentRoute == AdminRequestAcceptance.javaClass.name
