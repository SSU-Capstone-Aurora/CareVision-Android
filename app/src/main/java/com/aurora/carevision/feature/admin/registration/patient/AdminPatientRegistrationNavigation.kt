package com.aurora.carevision.feature.admin.registration.patient

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aurora.carevision.feature.admin.registration.patient.screen.AdminCameraListScreen
import com.aurora.carevision.feature.admin.registration.patient.screen.AdminCheckCameraInfoScreen
import com.aurora.carevision.feature.admin.registration.patient.screen.AdminCheckPatientNameScreen
import com.aurora.carevision.feature.admin.registration.patient.screen.AdminEnterPatientNumberScreen
import com.aurora.carevision.feature.admin.registration.patient.screen.AdminPatientRegistrationDone
import kotlinx.serialization.Serializable


@Serializable
data object AdminPatientRegistrationDone

@Serializable
data object AdminEnterPatientNumber

@Serializable
data object AdminCheckPatientName

@Serializable
data object AdminCameraListInfo

@Serializable
data object AdminCheckCameraInfo


//fun NavController.navigateToAdminPatientRegistration(navOptions: NavOptions? = null) =
//    navigate(AdminPatientRegistration, navOptions)

fun NavController.navigateToAdminPatientRegistrationDone(navOptions: NavOptions? = null) =
    navigate(AdminPatientRegistrationDone, navOptions)

fun NavController.navigateToEnterAdminPatientNumber(navOptions: NavOptions? = null) =
    navigate(AdminEnterPatientNumber, navOptions)

fun NavController.navigateToAdminCheckPatientName(navOptions: NavOptions? = null) =
    navigate(AdminCheckPatientName, navOptions)

fun NavController.navigateToAdminCameraListInfo(navOptions: NavOptions? = null) =
    navigate(AdminCameraListInfo, navOptions)

fun NavController.navigateToAdminCheckTotalInfo(navOptions: NavOptions? = null) =
    navigate(AdminCheckCameraInfo, navOptions)

fun NavGraphBuilder.adminPatientRegistrationScreen(
    navigateToAdminPatientRegistrationDone: () -> Unit, // 확인 화면으로 넘어가기
    navigateToAdminHome: () -> Unit, // 완료 후 환자 정보 화면으로 넘어가기
    navigateToEnterAdminPatientNumber: () -> Unit, // 환자 바코드 직접 입력 화면
    navigateToAdminCheckPatientName: () -> Unit, // 환자 이름 확인 화면
    navigateToAdminCameraListInfo: () -> Unit, // 환자 카메라 목록 화면
    navigateToAdminCheckTotalInfo: () -> Unit, // 등록 토탈 정보 확인
    onClickBack: () -> Unit
) {
//    composable<AdminPatientRegistration> {
//        AdminPatientRegistrationScreen(
//            onClickNavigateToAdminSelfRegistration = {
//                navigateToEnterAdminPatientNumber()
//            },
//            onClickNavigateToRegistrationDone = {
//                navigateToAdminPatientRegistrationDone()
//            },
//            onClickNavigateToBack = {
//                onClickBack()
//            }
//        )
//    }

    composable<AdminEnterPatientNumber> {
        AdminEnterPatientNumberScreen(
            navigateToCheckPatientInfo = {
                navigateToAdminCheckPatientName()
            },
            navigateToScanningBarcode = {
                // navigateToScanningBarcode()
            },
            navigateToBack = {
                onClickBack()
            }
        )
    }

    composable<AdminCheckPatientName> {
        AdminCheckPatientNameScreen(
            navigateToCameraListInfo = {
                navigateToAdminCameraListInfo()
            },
            onClickBack = {
                onClickBack()
            }
        )
    }

    composable<AdminCameraListInfo> {
        AdminCameraListScreen(
            onClickCheckFinishInfo = {
                navigateToAdminCheckTotalInfo()
            },
            onClickNavigateToBack = {
                onClickBack()
            },
        )
    }

    composable<AdminCheckCameraInfo> {
        AdminCheckCameraInfoScreen(
            navigateToDone = {
                navigateToAdminPatientRegistrationDone()
            },
            onClickBack = {
                onClickBack()
            },
        )
    }
    composable<AdminPatientRegistrationDone> {
        AdminPatientRegistrationDone(
            navigateToPatientInfo = {
                navigateToAdminHome()
            },
            onClickBack = {
                onClickBack()
            }
        )
    }


}