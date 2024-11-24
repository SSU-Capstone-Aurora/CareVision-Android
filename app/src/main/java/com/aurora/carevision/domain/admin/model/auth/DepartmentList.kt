package com.aurora.carevision.domain.admin.model.auth

data class DepartmentList (
    val departments: List<Department>,
    val totalCount: Int
) {
    data class Department(
        val id: Int,
        val name: String,
    )
}