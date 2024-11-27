package com.aurora.carevision.data.remote.admin.nurserequest.model

import com.aurora.carevision.data.remote.admin.auth.model.request.AdminNurseRequestList
import com.aurora.carevision.domain.admin.model.nurserequest.NurseRequestList
import com.aurora.carevision.feature.admin.request.NurseRequest
import kotlinx.serialization.Serializable

@Serializable
data class AcceptNurseResponse(
    val isSuccess: Boolean,
    val code: String,
    val message: String,
    val result: Result
) {
    @Serializable
    data class Result(
        val nurseId: Int,
        val name: String,
        val requestTime: String
    )
}

fun AcceptNurseResponse.Result.toDomainModel(): NurseRequest {
    return NurseRequest(
        nurseId = nurseId,
        name = name,
        requestTime = requestTime
    )
}
