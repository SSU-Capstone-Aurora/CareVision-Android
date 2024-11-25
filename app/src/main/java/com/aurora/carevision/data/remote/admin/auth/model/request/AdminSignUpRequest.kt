package com.aurora.carevision.data.remote.admin.auth.model.request

import com.aurora.carevision.domain.admin.model.auth.AdminUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AdminSignUpRequest(
    @SerialName("admin")
    val admin: Admin,
    @SerialName("hospital")
    val hospital: Hospital,
    @SerialName("department")
    val department: Department
) {
    @Serializable
    data class Admin(
        @SerialName("username")
        val username: String,
        @SerialName("password")
        val password: String
    )

    @Serializable
    data class Hospital(
        @SerialName("ykiho")
        val ykiho: String,
        @SerialName("name")
        val name: String
    )

    @Serializable
    data class Department(
        @SerialName("name")
        val name: String
    )
}

// Domain Model에서 Request Model로 변환하는 Mapper
fun AdminUser.toDataModel(): AdminSignUpRequest {
    return AdminSignUpRequest(
        admin = AdminSignUpRequest.Admin(
            username = userId,
            password = password
        ),
        hospital = AdminSignUpRequest.Hospital(
            ykiho = hospitalYkifo,
            name = hospitalName
        ),
        department = AdminSignUpRequest.Department(
            name = departmentName
        )
    )
}

