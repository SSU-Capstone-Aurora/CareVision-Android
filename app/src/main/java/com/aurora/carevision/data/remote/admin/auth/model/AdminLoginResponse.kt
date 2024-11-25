package com.aurora.carevision.data.remote.admin.auth.model

import com.aurora.carevision.domain.admin.model.auth.AdminUser
import kotlinx.serialization.Serializable

@Serializable
data class AdminLoginResponse(
    val accessToken: String = "",
    val refreshToken: String = "",
)

fun AdminLoginResponse.toDomainModel() = AdminUser(
    accessToken = accessToken,
    refreshToken = refreshToken
)