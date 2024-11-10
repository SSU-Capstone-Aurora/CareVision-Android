package com.aurora.carevision.feature.nurse.patient.registration

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object PatientRegistration

fun NavController.navigateToPatientRegistration(navOptions: NavOptions? = null) =
    navigate(PatientRegistration, navOptions)

fun NavGraphBuilder.patientRegistrationScreen(
    //navigateToNurseLogin: () -> Unit,
) {
    composable<PatientRegistration> {
        PatientRegistrationScreen(
            //
        )
    }
}