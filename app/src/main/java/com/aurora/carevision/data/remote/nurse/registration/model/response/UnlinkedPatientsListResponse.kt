package com.aurora.carevision.data.remote.nurse.registration.model.response

import com.aurora.carevision.domain.nurse.model.Patient
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UnlinkedPatientsListResponse(
    @SerialName("patients")
    val patients: List<UnlinkedPatientInfo>,
    @SerialName("count")
    val count: Int
) {
    @Serializable
    data class UnlinkedPatientInfo(
        @SerialName("id")
        val id: Int,
        @SerialName("name")
        val name: String,
        @SerialName("code")
        val patientCode: String,
        @SerialName("createdAt")
        val createdAt: String,
        @SerialName("inpatientWardNumber")
        val inpatientWardNumber: Int,
        @SerialName("bedNumber")
        val bedNumber: Int,
        @SerialName("patientRoomNumber")
        val patientRoomNumber: Int
    )
}

fun UnlinkedPatientsListResponse.toDomainModel(): List<Patient> {
    return patients.map {
        Patient(
            patientId = it.id,
            patientName = it.name,
            patientCode = it.patientCode,
            registrationDate = it.createdAt,
            inpatientWardNumber = it.inpatientWardNumber,
            bedNumber = it.bedNumber,
            patientRoom = it.patientRoomNumber
        )
    }
}