package com.aurora.carevision.feature.nurse.patient.registration

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aurora.carevision.feature.nurse.patient.registration.barcode.CameraListScreen
import com.aurora.carevision.feature.nurse.patient.registration.barcode.CheckCameraInfoScreen
import com.aurora.carevision.feature.nurse.patient.registration.barcode.CheckPatientNameScreen
import com.aurora.carevision.feature.nurse.patient.registration.barcode.EnterPatientNumberScreen
import com.aurora.carevision.feature.nurse.patient.registration.barcode.ScanningBarcodeScreen
import com.aurora.carevision.feature.nurse.patient.registration.search.PatientRegistrationDone
import com.aurora.carevision.feature.nurse.patient.registration.search.PatientRegistrationScreen
import kotlinx.serialization.Serializable

@Serializable
data object PatientRegistration

@Serializable
data object PatientRegistrationDone

@Serializable
data object EnterPatientNumber

@Serializable
data object CheckPatientName

@Serializable
data object CameraListInfo

@Serializable
data object CheckCameraInfo

@Serializable
data object ScanningBarcode

fun NavController.navigateToPatientRegistration(navOptions: NavOptions? = null) =
    navigate(PatientRegistration, navOptions)

fun NavController.navigateToPatientRegistrationDone(navOptions: NavOptions? = null) =
    navigate(PatientRegistrationDone, navOptions)

fun NavController.navigateToEnterPatientNumber(navOptions: NavOptions? = null) =
    navigate(EnterPatientNumber, navOptions)

fun NavController.navigateToCheckPatientName(navOptions: NavOptions? = null) =
    navigate(CheckPatientName, navOptions)

fun NavController.navigateToCameraListInfo(navOptions: NavOptions? = null) =
    navigate(CameraListInfo, navOptions)

fun NavController.navigateToCheckTotalInfo(navOptions: NavOptions? = null) =
    navigate(CheckCameraInfo, navOptions)

fun NavController.navigateToScanningBarcode(navOptions: NavOptions? = null) =
    navigate(ScanningBarcode, navOptions)


fun NavGraphBuilder.patientRegistrationScreen(
    navigateToPatientRegistration: () -> Unit, // 환자 등록 화면으로 넘어가기
    navigateToPatientRegistrationDone: () -> Unit, // 확인 화면으로 넘어가기
    navigateToPatientInfo: () -> Unit, // 완료 후 환자 정보 화면으로 넘어가기
    navigateToEnterPatientNumber: () -> Unit, // 환자 바코드 직접 입력 화면
    navigateToCheckPatientName: () -> Unit, // 환자 이름 확인 화면
    navigateToCameraListInfo: () -> Unit, // 환자 카메라 목록 화면
    navigateToCheckTotalInfo: () -> Unit, // 등록 토탈 정보 확인
    navigateToScanningBarcode: () -> Unit, // 바코드 스캔 화면
    onClickBack: () -> Unit
) {
    composable<PatientRegistration> {
        PatientRegistrationScreen(
            onClickNavigateToSelfRegistration = {
                navigateToEnterPatientNumber()
            },
            onClickNavigateToRegistrationDone = {
                navigateToPatientRegistrationDone()
            },
            onClickNavigateToBack = {
                onClickBack()
            }
        )
    }

    composable<PatientRegistrationDone> {
        PatientRegistrationDone(
            navigateToPatientInfo = {
                navigateToPatientInfo()
            },
            onClickBack = {
                onClickBack()
            }
        )
    }


    composable<EnterPatientNumber> {
        EnterPatientNumberScreen(
            navigateToCheckPatientInfo = {
                navigateToCheckPatientName()
            },
            navigateToScanningBarcode = {
                navigateToScanningBarcode()
            },
            navigateToBack = {
                onClickBack()
            }
        )
    }

    composable<CheckPatientName> {
        CheckPatientNameScreen(
            navigateToCameraListInfo = {
                navigateToCameraListInfo()
            },
            onClickBack = {
                onClickBack()
            }
        )
    }

    composable<CameraListInfo> {
        CameraListScreen(
            onClickCheckFinishInfo = {
                navigateToCheckTotalInfo()
            },
            onClickNavigateToBack = {
                onClickBack()
            },
        )
    }

    composable<CheckCameraInfo> {
        CheckCameraInfoScreen(
            navigateToDone = {
                navigateToPatientRegistration()
            },
            onClickBack = {
                onClickBack()
            },
        )
    }

    composable<ScanningBarcode> {
        ScanningBarcodeScreen(
            navigateToEnterPatientNumber = {
                navigateToEnterPatientNumber()
            }
        )
    }
}