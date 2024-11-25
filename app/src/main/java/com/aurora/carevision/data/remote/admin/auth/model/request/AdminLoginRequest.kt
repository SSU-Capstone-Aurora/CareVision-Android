package com.aurora.carevision.data.remote.admin.auth.model.request

import com.aurora.carevision.domain.admin.model.auth.AdminUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AdminLoginRequest(
    @SerialName("username")
    val userId: String,
    @SerialName("password")
    val password: String
)

fun AdminUser.toDataAdminLoginModel(): AdminLoginRequest {
    return AdminLoginRequest(
        userId = userId,
        password = password
    )
}