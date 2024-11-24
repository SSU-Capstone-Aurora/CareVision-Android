package com.aurora.carevision.data.remote.admin.auth.model.request

import com.aurora.carevision.domain.admin.model.auth.AdminUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AdminSignUpRequest(
    @SerialName("admin")
    val admin: Admin,
    @SerialName("department")
    val departmentId: Int
){
    @Serializable
    data class Admin(
        @SerialName("name")
        val username: String,
        @SerialName("username")
        val userId: String,
        @SerialName("password")
        val password: String
    )
}

fun AdminUser.toDataModel(): AdminSignUpRequest {
    return AdminSignUpRequest(
        AdminSignUpRequest.Admin(
            username = name,
            userId = userId,
            password = password
        ),
        departmentId = departmentId
    )
}