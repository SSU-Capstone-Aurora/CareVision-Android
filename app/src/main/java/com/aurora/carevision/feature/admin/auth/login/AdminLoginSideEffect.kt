package com.aurora.carevision.feature.admin.auth.login


sealed class AdminLoginSideEffect {
    data class ShowToast(val text: String) : AdminLoginSideEffect()
    data class OnUserIdChange(val userId: String) : AdminLoginSideEffect()
    data class OnPasswordChange(val password: String) : AdminLoginSideEffect()
    object OnLoginClick : AdminLoginSideEffect()
    object OnSignUpClick : AdminLoginSideEffect()
    object OnBackClick : AdminLoginSideEffect()
    object NavigateToHome : AdminLoginSideEffect()
}