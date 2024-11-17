package com.aurora.carevision.feature.admin.auth.login

data class AdminLoginState(
    val userId: String = "",
    val password: String = "",
    val isLoginError: Boolean = false,
    val isLoginSuccess: Boolean = false,
    val isLoginLoading: Boolean = false
)