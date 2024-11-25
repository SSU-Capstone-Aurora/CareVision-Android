package com.aurora.carevision.data.remote.nurse.auth.model.request

import com.aurora.carevision.domain.nurse.model.auth.NurseUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NurseLoginRequest(
    @SerialName("username")
    val userId: String,
    @SerialName("password")
    val password: String
)

fun NurseUser.toDataNurseLoginModel(): NurseLoginRequest {
    return NurseLoginRequest(
        userId = userId,
        password = password
    )
}