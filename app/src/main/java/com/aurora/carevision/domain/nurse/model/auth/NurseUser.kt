package com.aurora.carevision.domain.nurse.model.auth

data class NurseUser(
    val id: Int = 0,
    val name: String = "",
    val userId: String = "",
    val password: String = "",
    val hospitalId: Int = 0,
    val departmentId: Int = 0,
    val accessToken: String = "",
    val refreshToken: String = "",
)