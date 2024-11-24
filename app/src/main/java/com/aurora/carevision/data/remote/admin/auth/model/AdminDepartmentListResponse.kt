package com.aurora.carevision.data.remote.admin.auth.model

import com.aurora.carevision.domain.admin.model.auth.DepartmentList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AdminDepartmentListResponse(
    @SerialName("departments")
    val departments: List<Department>,
    @SerialName("totalCount")
    val totalCount: Int
) {
    @Serializable
    data class Department(
        @SerialName("id")
        val id: Int,
        @SerialName("name")
        val name: String,
    )
}

fun AdminDepartmentListResponse.toDomainModel(): DepartmentList {
    return DepartmentList(
        departments = this.departments.map { department ->
            DepartmentList.Department(
                id = department.id,
                name = department.name
            )
        },
        totalCount = this.totalCount
    )
}