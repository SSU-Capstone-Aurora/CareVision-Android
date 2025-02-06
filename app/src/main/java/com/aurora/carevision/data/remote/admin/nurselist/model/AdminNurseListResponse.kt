package com.aurora.carevision.data.remote.admin.nurselist.model

import com.aurora.carevision.domain.admin.model.nurse.NurseInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NurseListResponse(
    @SerialName("nurseList")
    val nurses: List<Nurse> = emptyList(),
    @SerialName("count")
    val count: Int = 0
) {
    @Serializable
    data class Nurse(
        @SerialName("id")
        val id: String,
        @SerialName("name")
        val name: String,
    )
}

fun NurseListResponse.toDomainModel(): List<NurseInfo> {
    return nurses.map {
        NurseInfo(
            id = it.id,
            name = it.name
        )
    }
}

