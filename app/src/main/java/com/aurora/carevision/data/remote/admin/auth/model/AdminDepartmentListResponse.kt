package com.aurora.carevision.data.remote.admin.auth.model

import com.aurora.carevision.domain.admin.model.auth.DepartmentList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AdminDepartmentListResponse(
    @SerialName("departments")
    val departments: List<String>,
    @SerialName("totalCount")
    val totalCount: Int
)

fun AdminDepartmentListResponse.toDomainModel(): DepartmentList {
    return DepartmentList(
        departments = this.departments,
        totalCount = this.totalCount
    )
}