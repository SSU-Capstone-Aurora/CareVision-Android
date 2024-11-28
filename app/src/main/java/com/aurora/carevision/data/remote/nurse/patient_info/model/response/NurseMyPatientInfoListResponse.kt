package com.aurora.carevision.data.remote.nurse.patient_info.model.response

import com.aurora.carevision.domain.nurse.model.Patient
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NurseMyPatientInfoListResponse(
    @SerialName("patients")
    val patientList :List<MyPatientInfo>
){
    @Serializable
    data class MyPatientInfo(
        @SerialName("id")
        val patientId: Int,
        @SerialName("name")
        val patientName: String,
        @SerialName("code")
        val patientCode: String,
        @SerialName("createdAt")
        val patientCreatedAt: String,
        @SerialName("inpatientWardNumber")
        val inpatientWardNumber: Int,
        @SerialName("patientRoomNumber")
        val patientRoomNumber: Int,
        @SerialName("bedNumber")
        val bedNumber: Int,
    )
}

fun NurseMyPatientInfoListResponse.toDomainModel(): List<Patient> {
    return patientList.map {
        Patient(
            patientId = it.patientId,
            patientName = it.patientName,
            patientCode = it.patientCode,
            registrationDate = it.patientCreatedAt,
            inpatientWardNumber = it.inpatientWardNumber,
            patientRoom = it.patientRoomNumber,
            bedNumber = it.bedNumber
        )
    }
}