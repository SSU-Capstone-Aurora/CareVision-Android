package com.aurora.carevision.data.remote.admin.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HospitalListResponse(
    @SerialName("hospitals")
    val hospitals: List<Hospital>,
    @SerialName("totalCount")
    val totalCount: Int
) {
    @Serializable
    data class Hospital(
        @SerialName("name")
        val name: String,
        @SerialName("address")
        val address: String,
        @SerialName("ykiho")
        val ykiho: String
    )
}