package com.aurora.carevision.feature.nurse.mypage

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object NurseMypage

fun NavController.navigateToNurseMypage(navOptions: NavOptions? = null) =
    navigate(NurseMypage, navOptions)

fun NavGraphBuilder.nurseMypageScreen(
    //navigateToNurseLogin: () -> Unit,
) {
    composable<NurseMypage> {
        MypageScreen(
            //
        )
    }
}