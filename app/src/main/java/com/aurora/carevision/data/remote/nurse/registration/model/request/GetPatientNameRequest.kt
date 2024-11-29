package com.aurora.carevision.data.remote.nurse.registration.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetPatientNameRequest(
    @SerialName("code")
    val patientCode: String
)

fun String.toDataModel(): GetPatientNameRequest {
    return GetPatientNameRequest(
        patientCode = this
    )
}