package com.aurora.carevision.data.remote.nurse.registration.model.response

import android.hardware.Camera
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UnlinkedCameraListResponse(
    @SerialName("cameraInfoList")
    val cameraInfoList: List<CameraInfo>,
    @SerialName("totalCount")
    val totalCount: Int
){
    @Serializable
    data class CameraInfo(
        @SerialName("cameraId")
        val cameraId: String,
        @SerialName("inpatientWardNumber")
        val inpatientWardNumber: Int,
        @SerialName("patientRoomNumber")
        val patientRoomNumber: Int,
        @SerialName("bedNumber")
        val bedNumber: Int,
    )
}

fun UnlinkedCameraListResponse.toDomainModel(): List<com.aurora.carevision.domain.nurse.model.Camera> {
    return cameraInfoList.map {
        com.aurora.carevision.domain.nurse.model.Camera(
            cameraCode = it.cameraId,
            inpatientWardNumber = it.inpatientWardNumber,
            patientRoomNumber = it.patientRoomNumber,
            bedNumber = it.bedNumber,
        )
    }
}
