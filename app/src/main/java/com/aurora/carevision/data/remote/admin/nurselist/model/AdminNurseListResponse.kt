package com.aurora.carevision.data.remote.admin.nurselist.model

import com.aurora.carevision.domain.admin.model.nurserequest.NurseList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NurseListResponse(
    @SerialName("nurses")
    val nurses: List<NurseResponse>,
    @SerialName("count")
    val count: Int,
) {
    @Serializable
    data class NurseResponse(
        @SerialName("id")
        val id: String,
        @SerialName("name")
        val name: String,
    )
}

fun NurseListResponse.toDomainModel(): NurseList {
    return NurseList(
        nurseList = this.nurses.map { nurses ->
            NurseList.NurseList(
                id = nurses.id,
                name = nurses.name
            )
        },
        count = this.count
    )
}

