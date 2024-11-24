package com.aurora.carevision.data.remote.admin.auth.model

import com.aurora.carevision.domain.admin.model.auth.AdminUser
import kotlinx.serialization.Serializable

@Serializable
data class AdminSignUpResponse(
    val id: Int = 0,
    val name: String = "",
)

fun AdminSignUpResponse.toDomainModel() = AdminUser(id = id, name = name)