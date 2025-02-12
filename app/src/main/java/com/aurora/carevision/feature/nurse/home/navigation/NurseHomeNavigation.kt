package com.aurora.carevision.feature.nurse.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aurora.carevision.feature.nurse.home.LiveStreamingScreen
import com.aurora.carevision.feature.nurse.home.NotificationRoute
import com.aurora.carevision.feature.nurse.home.SavedVideoScreen
import com.aurora.carevision.feature.nurse.home.home.HomeRoute
import com.aurora.carevision.feature.nurse.home.home.HomeViewModel
import kotlinx.serialization.Serializable

@Serializable
data object NurseHome

@Serializable
data object NurseStreaming

@Serializable
data object NurseSavedVideo

@Serializable
data object NurseNotificationList

fun NavController.navigateToNurseHome(navOptions: NavOptions? = null) = navigate(NurseHome, navOptions)
fun NavController.navigateToNurseStreaming(navOptions: NavOptions? = null) = navigate(NurseStreaming, navOptions)
fun NavController.navigateToNurseSavedVideo(navOptions: NavOptions? = null) = navigate(NurseSavedVideo, navOptions)
fun NavController.navigateToNurseNotificationList(navOptions: NavOptions? = null) = navigate(NurseNotificationList, navOptions)

fun NavGraphBuilder.nurseHomeScreen(
    navigateToSpecificPatientStreamingScreen: () -> Unit,
    navigateToSavedVideoScreen: () -> Unit,
    navigateToNotificationList: () -> Unit,
    onBackClick: () -> Unit,
    viewModel: HomeViewModel
) {
    composable<NurseHome> {
        HomeRoute(
            navigateToSpecificPatientStreaming = navigateToSpecificPatientStreamingScreen,
            navigateToNotificationList = navigateToNotificationList,
            viewModel = viewModel
        )
    }

    composable<NurseStreaming> {
        LiveStreamingScreen(
            navigateToSavedVideoScreen = navigateToSavedVideoScreen,
            onBackClick = onBackClick,
            viewModel = viewModel
        )
    }

    composable<NurseSavedVideo> {
        SavedVideoScreen(
            onBackClick = onBackClick,
            viewModel = viewModel
        )
    }

    composable<NurseNotificationList> {
        NotificationRoute(
            onBackClick = onBackClick,
            navigateToSpecificPatientStreaming = navigateToSpecificPatientStreamingScreen,
            viewModel = viewModel
        )
    }
}