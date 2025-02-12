package com.aurora.carevision.feature.admin.registration.camera

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aurora.carevision.feature.admin.registration.camera.connection.CameraRegisterAfterBarCodeRoute
import com.aurora.carevision.feature.admin.registration.camera.connection.CameraRegistrationInfoRoute
import com.aurora.carevision.feature.admin.registration.camera.connection.CameraRegisterFinishRoute
import kotlinx.serialization.Serializable

@Serializable
data object CameraRegistAfterBarCode

@Serializable
data object CameraRegistrationInfo

@Serializable
data object CameraRegistFinish

fun NavController.navigateToCameraRegistAfterBarCode(navOptions: NavOptions? = null) =
    navigate(CameraRegistAfterBarCode, navOptions)

fun NavController.navigateToCameraRegistrationInfo(navOptions: NavOptions? = null) =
    navigate(CameraRegistrationInfo, navOptions)

fun NavController.navigateToCameraRegistFinish(navOptions: NavOptions? = null) =
    navigate(CameraRegistFinish, navOptions)

fun NavGraphBuilder.cameraRegistrationScreen(
    viewModel: CameraRegistrationViewModel,
    navigateToCameraRegistrationInfo: () -> Unit,
    navigateToCameraRegistFinish: () -> Unit,
    navigateToBack: () -> Unit,
    onFinish: () -> Unit
) {
    composable<CameraRegistAfterBarCode> {
        CameraRegisterAfterBarCodeRoute(
            navigateToInfo = navigateToCameraRegistrationInfo,
            navigateToBack = navigateToBack
        )
    }

    composable<CameraRegistrationInfo> {
        CameraRegistrationInfoRoute(
            navigateToFinish = navigateToCameraRegistFinish,
            navigateToBack = navigateToBack
        )
    }

    composable<CameraRegistFinish> {
        CameraRegisterFinishRoute(
            onFinish = onFinish,
            navigateToBack = navigateToBack
        )
    }
}