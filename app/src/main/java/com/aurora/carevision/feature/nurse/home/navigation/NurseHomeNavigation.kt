package com.aurora.carevision.feature.nurse.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aurora.carevision.feature.nurse.home.LiveStreamingScreen
import com.aurora.carevision.feature.nurse.home.SavedVideoScreen
import com.aurora.carevision.feature.nurse.home.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object NurseHome

@Serializable
data object NurseStreaming

@Serializable
data object NurseSavedVideo

fun NavController.navigateToNurseHome(navOptions: NavOptions? = null) = navigate(NurseHome, navOptions)
fun NavController.navigateToNurseStreaming(navOptions: NavOptions? = null) = navigate(NurseStreaming, navOptions)
fun NavController.navigateToNurseSavedVideo(navOptions: NavOptions? = null) = navigate(NurseSavedVideo, navOptions)

fun NavGraphBuilder.nurseHomeScreen(
    navigateToSpecificPatientStreamingScreen: () -> Unit,
    navigateToSavedVideoScreen: () -> Unit,
    onBackClick: () -> Unit
) {
    composable<NurseHome> {
        HomeScreen(
            navigateToSpecificPatientStreaming = navigateToSpecificPatientStreamingScreen
        )
    }

    composable<NurseStreaming> {
        LiveStreamingScreen(
            navigateToSavedVideoScreen = navigateToSavedVideoScreen,
            onBackClick = onBackClick
        )
    }

    composable<NurseSavedVideo> {
        SavedVideoScreen(
            onBackClick = onBackClick
        )
    }
}