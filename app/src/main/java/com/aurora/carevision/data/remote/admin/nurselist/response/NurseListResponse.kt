package com.aurora.carevision.data.remote.admin.nurselist.response

import com.aurora.carevision.domain.admin.model.nurserequest.NurseList
import kotlinx.serialization.Serializable

@Serializable
data class NurseListResponse(
    val nurseList: List<NurseItem>,
    val count: Int
) {
    @Serializable
    data class NurseItem(
        val id: String,
        val name: String
    )
}

fun NurseListResponse.toDomainModel(): List<NurseList.NurseList> {
    return nurseList.map {
        NurseList.NurseList(
            id = it.id,
            name = it.name,
        )
    }
}