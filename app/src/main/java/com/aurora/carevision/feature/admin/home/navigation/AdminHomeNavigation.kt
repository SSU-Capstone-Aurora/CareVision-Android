package com.aurora.carevision.feature.admin.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aurora.carevision.feature.admin.home.AdminListScreen
import kotlinx.serialization.Serializable

// AdminHome 화면을 정의 Router에서 사용할 수 있도록 Serializable로 정의
@Serializable
data object AdminHome

// AdminHome 화면으로 외부에서 들어올 수 있게 하기 위해 NavController에 확장함수를 정의
fun NavController.navigateToAdminHome(navOptions: NavOptions? = null) = navigate(AdminHome, navOptions)

// AdminHome 화면을 정의
fun NavGraphBuilder.adminHomeScreen(
    // admin home 화면에서 이동해야하는 모든 도착지에 대한 함수들을 정의
    // navigateToRequestAcceptance: () -> Unit,
) {
    composable<AdminHome> {
        AdminListScreen()
    }
}