package com.aurora.carevision.data.remote.admin.patientlist.model

import com.aurora.carevision.domain.admin.model.patient.Patient
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AdminPatientListResponse(
    @SerialName("patientList")
    val patientList: List<Patient> = emptyList(),
    @SerialName("hasNext")
    val hasNext: Boolean,
    @SerialName("nextCursor")
    val nextCursor: Int
) {
    @Serializable
    data class Patient(
        @SerialName("patientName")
        val patientName: String,
        @SerialName("inpatientWardNumber")
        val inpatientWardNumber: Int,
        @SerialName("patientRoomNumber")
        val patientRoomNumber: Int,
        @SerialName("bedNumber")
        val bedNumber: Int,
        @SerialName("code")
        val code: String
    )
}
fun AdminPatientListResponse.toDomainModel(): List<Patient>{
    return patientList.map{
        Patient(
            patientName = it.patientName,
            inpatientWardNumber = it.inpatientWardNumber,
            patientRoom = it.patientRoomNumber,
            bedNumber = it.bedNumber,
            code = it.code
        )
    }
}