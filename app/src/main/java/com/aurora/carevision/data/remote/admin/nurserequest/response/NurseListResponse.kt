package com.aurora.carevision.data.remote.admin.nurserequest.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NurseListResponse(
    @SerialName("nurseList")
    val nurseList: List<Nurse>,
    @SerialName("count")
    val count: Int
) {
    @Serializable
    data class Nurse(
        @SerialName("name")
        val name: String,
        @SerialName("id")
        val id: String
    )
}