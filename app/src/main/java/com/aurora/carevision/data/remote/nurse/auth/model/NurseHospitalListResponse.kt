package com.aurora.carevision.data.remote.nurse.auth.model

import com.aurora.carevision.domain.nurse.model.auth.HospitalList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NurseHospitalListResponse(
    @SerialName("hospitals")
    val hospitals: List<Hospital>,
    @SerialName("totalCount")
    val totalCount: Int
) {
    @Serializable
    data class Hospital(
        @SerialName("id")
        val id: Int,
        @SerialName("name")
        val name: String,
    )
}

// mapper
// 서버에서 받은 값을 Domain Model로 변환
// data 계층에서 확장함수를 만든 이유는 Domain Model이 data 계층에 의존하면 안되기 때문
fun NurseHospitalListResponse.toDomainModel(): HospitalList {
    return HospitalList(
        hospitals = this.hospitals.map { hospital ->
            HospitalList.Hospital(
                id = hospital.id,
                name = hospital.name
            )
        },
        totalCount = this.totalCount
    )
}