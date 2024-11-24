package com.aurora.carevision.data.remote.nurse.mypage.model.response

import com.aurora.carevision.domain.nurse.model.mypage.NurseMypage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NurseMypageResponse(
    @SerialName("name")
    val nurseName: String,
    @SerialName("registeredAt")
    val registeredAt: String?,
    @SerialName("hospitalName")
    val hospitalName: String,
    @SerialName("department")
    val department: String,
)

fun NurseMypageResponse.toDomainModel(): NurseMypage {
    return NurseMypage(
        name = nurseName,
        registeredAt = registeredAt,
        hospitalName = hospitalName,
        department = department
    )
}
