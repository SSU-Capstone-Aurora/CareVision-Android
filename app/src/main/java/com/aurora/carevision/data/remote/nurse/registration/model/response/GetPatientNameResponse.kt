package com.aurora.carevision.data.remote.nurse.registration.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetPatientNameResponse (
    @SerialName("name")
    val patientName: String
)

fun GetPatientNameResponse.toDomainModel(): String {
    return patientName
}