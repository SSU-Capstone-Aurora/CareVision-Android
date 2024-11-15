package com.aurora.carevision.feature.nurse.patient.registration

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aurora.carevision.feature.nurse.patient.registration.search.PatientRegistrationDone
import com.aurora.carevision.feature.nurse.patient.registration.search.PatientRegistrationScreen
import kotlinx.serialization.Serializable

@Serializable
data object PatientRegistration

@Serializable
data object PatientRegistrationDone

fun NavController.navigateToPatientRegistration(navOptions: NavOptions? = null) =
    navigate(PatientRegistration, navOptions)

fun NavController.navigateToPatientRegistrationDone(navOptions: NavOptions? = null) =
    navigate(PatientRegistrationDone, navOptions)

fun NavGraphBuilder.patientRegistrationScreen(
    navigateToPatientRegistration: () -> Unit, // 뒤로가기
    navigateToPatientRegistrationDone: () -> Unit, // 확인 화면으로 넘어가기
    navigateToPatientInfo: () -> Unit // 완료 후 환자 정보 화면으로 넘어가기
) {
    composable<PatientRegistration> {
        PatientRegistrationScreen(
            onClickNavigateToSelfRegistration = {
                //onClickNavigateToSelfRegistration()
            },
            onClickNavigateToRegistrationDone = {
                navigateToPatientRegistrationDone()
            },
            onClickNavigateToBack = {
                navigateToPatientInfo()
            }
        )
    }

    composable<PatientRegistrationDone> {
        PatientRegistrationDone(
            navigateToPatientInfo = {
                navigateToPatientInfo()
            },
            onClickBack = {
                navigateToPatientRegistration()
            }
        )
    }
}