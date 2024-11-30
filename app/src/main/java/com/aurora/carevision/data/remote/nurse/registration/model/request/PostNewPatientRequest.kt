package com.aurora.carevision.data.remote.nurse.registration.model.request

import com.aurora.carevision.domain.nurse.model.Patient
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class PostNewPatientRequest (
    @SerialName("patient")
    val newPatientInfo: NewPatientInfo,
    @SerialName("camera")
    val cameraInfo: CameraInfo,
){
    @Serializable
    class NewPatientInfo (
        @SerialName("name")
        val name: String,
        @SerialName("code")
        val code: String,
        @SerialName("bed")
        val bed: Bed,
    ){
        @Serializable
        class Bed (
            @SerialName("inpatientWardNumber")
            val inpatientWardNumber: Int,
            @SerialName("patientRoomNumber")
            val patientRoomNumber: Int,
            @SerialName("bedNumber")
            val bedNumber: Int,
        )
    }
    @Serializable
    class CameraInfo(
        @SerialName("id")
        val cameraId: String,
    )
}

fun Patient.toDataModel(): PostNewPatientRequest {
    return PostNewPatientRequest(
        newPatientInfo = PostNewPatientRequest.NewPatientInfo(
            name = patientName,
            code = patientCode,
            bed = PostNewPatientRequest.NewPatientInfo.Bed(
                inpatientWardNumber = inpatientWardNumber,
                patientRoomNumber = patientRoom,
                bedNumber = bedNumber,
            ),
        ),
        cameraInfo = PostNewPatientRequest.CameraInfo(
            cameraId = cameraId,
        ),
    )
}