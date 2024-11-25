package com.aurora.carevision.feature.nurse.auth.login

sealed class NurseLoginSideEffect {
    object LoginSuccess : NurseLoginSideEffect()
    data class ShowToast(val text: String) : NurseLoginSideEffect()
    object OnSignUpClick : NurseLoginSideEffect()
    object OnBackClick : NurseLoginSideEffect()
    object NavigateToHome : NurseLoginSideEffect()
}