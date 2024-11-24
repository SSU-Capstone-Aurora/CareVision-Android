package com.aurora.carevision.data.remote.admin.auth.model

import com.aurora.carevision.domain.admin.model.auth.HospitalList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AdminHospitalListResponse(
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

// mapper
// 서버에서 받은 값을 Domain Model로 변환
// data 계층에서 확장함수를 만든 이유는 Domain Model이 data 계층에 의존하면 안되기 때문
fun AdminHospitalListResponse.toDomainModel(): HospitalList {
    return HospitalList(
        hospitals = this.hospitals.map { hospital ->
            HospitalList.Hospital(
                ykiho = hospital.ykiho,
                name = hospital.name,
                address = hospital.address
            )
        },
        totalCount = this.totalCount
    )
}