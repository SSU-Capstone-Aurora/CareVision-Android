package com.aurora.carevision.domain.admin.model.auth

data class HospitalList(
    val hospitals: List<Hospital>,
    val totalCount: Int
) {
    data class Hospital(
        val id: Int,
        val name: String,
        val address: String
    )
}