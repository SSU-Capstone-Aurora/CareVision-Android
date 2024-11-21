package com.aurora.carevision.data.remote.nurse.auth.model.request

import com.aurora.carevision.domain.nurse.model.auth.NurseUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NurseSignUpRequest(
    @SerialName("nurse")
    val nurse: Nurse,
    @SerialName("department")
    val departmentId: Int
){
    @Serializable
    data class Nurse(
        @SerialName("name")
        val username: String,
        @SerialName("username")
        val userId: String,
        @SerialName("password")
        val password: String
    )
}

fun NurseUser.toDataModel(): NurseSignUpRequest {
    return NurseSignUpRequest(
        NurseSignUpRequest.Nurse(
            username = name,
            userId = userId,
            password = password
        ),
        departmentId = departmentId
    )
}