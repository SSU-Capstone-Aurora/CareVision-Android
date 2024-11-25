package com.aurora.carevision.data.remote.nurse.auth.model

import com.aurora.carevision.domain.nurse.model.auth.NurseUser
import kotlinx.serialization.Serializable

@Serializable
data class NurseLoginResponse(
    val accessToken: String = "",
    val refreshToken: String = "",
)

fun NurseLoginResponse.toDomainModel() = NurseUser(
    accessToken = accessToken,
    refreshToken = refreshToken
)