package com.aurora.carevision.feature.admin.request

sealed class AdminRequestAcceptanceSideEffect {
    data class ShowError(val message: String) : AdminRequestAcceptanceSideEffect()
}