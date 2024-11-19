package com.aurora.carevision.feature.admin.registration.camera

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aurora.carevision.feature.admin.registration.camera.connection.CameraRegistAfterBarCodeScreen
import com.aurora.carevision.feature.admin.registration.camera.connection.CameraRegistrationInfoScreen
import com.aurora.carevision.feature.admin.registration.camera.connection.CameraRegistFinishScreen
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
        CameraRegistAfterBarCodeScreen(
            navigateToInfo = navigateToCameraRegistrationInfo,
            navigateToBack = navigateToBack
        )
    }

    composable<CameraRegistrationInfo> {
        CameraRegistrationInfoScreen(
            navigateToFinish = navigateToCameraRegistFinish,
            navigateToBack = navigateToBack
        )
    }

    composable<CameraRegistFinish> {
        CameraRegistFinishScreen(
            onFinish = onFinish,
            navigateToBack = navigateToBack
        )
    }
}