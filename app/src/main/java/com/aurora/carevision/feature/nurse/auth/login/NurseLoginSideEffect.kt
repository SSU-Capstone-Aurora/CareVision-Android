package com.aurora.carevision.feature.nurse.auth.login

sealed class NurseLoginSideEffect {
    data class ShowToast(val text: String) : NurseLoginSideEffect()
    data class OnUserIdChange(val userId: String) : NurseLoginSideEffect()
    data class OnPasswordChange(val password: String) : NurseLoginSideEffect()
    object OnLoginClick : NurseLoginSideEffect()
    object OnSignUpClick : NurseLoginSideEffect()
    object OnBackClick : NurseLoginSideEffect()
    object NavigateToHome : NurseLoginSideEffect()
}