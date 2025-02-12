package com.aurora.carevision.feature.admin.request

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

// AdminHome 화면을 정의 Router에서 사용할 수 있도록 Serializable로 정의
@Serializable
data object AdminRequestAcceptance

// AdminHome 화면으로 외부에서 들어올 수 있게 하기 위해 NavController에 확장함수를 정의
fun NavController.navigateToAdminRequestAcceptance(navOptions: NavOptions? = null) = navigate(AdminRequestAcceptance, navOptions)

fun NavGraphBuilder.adminRequestAcceptanceScreen(
    //navigateToHome : () ->Unit,
    navigateToBack : () ->Unit,

) {
    composable<AdminRequestAcceptance> {
        AdminRequestAcceptanceRoute()
    }
}