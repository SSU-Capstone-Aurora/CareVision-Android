package com.aurora.carevision.data.remote.admin.nurserequest.model

import com.aurora.carevision.domain.admin.model.nurserequest.NurseRequestList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AdminNurseRequestResponse(
    @SerialName("requestCount")
    val requestCount: Int,
    @SerialName("requests")
    val requests: List<Request>
) {
    @Serializable
    data class Request(
        @SerialName("nurseId")
        val nurseId: Int,
        @SerialName("name")
        val name: String,
        @SerialName("username")
        val username: String,
        @SerialName("requestTime")
        val requestTime: String
    )
}

fun AdminNurseRequestResponse.toDomainModel() = NurseRequestList(
    requestCount = requestCount,
    requests = requests.map { request ->
        NurseRequestList.NurseRequest(
            nurseId = request.nurseId,
            name = request.name,
            username = request.username,
            requestTime = request.requestTime
        )
    }
)