package com.aurora.carevision.feature.nurse.patient.info

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object PatientInfo

fun NavController.navigateToPatientInfo(navOptions: NavOptions? = null) =
    navigate(PatientInfo, navOptions)

fun NavGraphBuilder.patientInfoScreen(
    //navigateToNurseLogin: () -> Unit,
) {
    composable<PatientInfo> {
        PatientInfoScreen(
            //
        )
    }
}