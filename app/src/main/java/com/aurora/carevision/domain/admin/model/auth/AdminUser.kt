package com.aurora.carevision.domain.admin.model.auth

data class AdminUser(
    val id: Int = 0,
    val name: String = "",
    val userId: String = "",
    val password: String = "",
    val hospitalId: Int = 0,
    val departmentId: Int = 0,
)