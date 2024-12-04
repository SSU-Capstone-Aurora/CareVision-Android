package com.aurora.carevision.data.remote.nurse.registration.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostAlreadyPatientRequest (
    @SerialName("patientId")
    val patientId: Int
)

fun Int.toDataModel(): PostAlreadyPatientRequest {
    return PostAlreadyPatientRequest(
        patientId = this
    )
}