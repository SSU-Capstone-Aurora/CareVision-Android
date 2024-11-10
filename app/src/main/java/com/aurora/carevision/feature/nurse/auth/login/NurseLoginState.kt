package com.aurora.carevision.feature.nurse.auth.login

data class NurseLoginState(
    val userId: String = "",
    val password: String = "",
    val isLoginError: Boolean = false,
    val isLoginSuccess: Boolean = false,
    val isLoginLoading: Boolean = false,
)
