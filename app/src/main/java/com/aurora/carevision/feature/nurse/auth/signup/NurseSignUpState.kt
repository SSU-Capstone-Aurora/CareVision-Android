package com.aurora.carevision.feature.nurse.auth.signup

data class NurseSignUpState(
    val hospitalName: String = "",
    val department: String = "",
    val userName: String = "",
    val userId: String = "",
    val password: String = "",
    val doCheckNameDuplicate: Boolean = false,
    val nameDuplicate: Boolean = true,
)
