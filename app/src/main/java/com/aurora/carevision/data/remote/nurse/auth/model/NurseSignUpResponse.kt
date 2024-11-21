package com.aurora.carevision.data.remote.nurse.auth.model

import com.aurora.carevision.domain.nurse.model.auth.NurseUser
import kotlinx.serialization.Serializable

@Serializable
data class NurseSignUpResponse(
    val id: Int = 0,
    val name: String = "",
)

fun NurseSignUpResponse.toDomainModel() = NurseUser(id = id, name = name)