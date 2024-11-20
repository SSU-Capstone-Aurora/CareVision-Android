package com.aurora.carevision.data.remote.nurse.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NurseDepartmentListResponse(
    @SerialName("departments")
    val departments: List<Department>,
    @SerialName("totalCount")
    val totalCount: Int
) {
    @Serializable
    data class Department(
        @SerialName("id")
        val id: String,
        @SerialName("name")
        val name: String,
    )
}