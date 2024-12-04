package com.aurora.carevision.data.remote.admin.cameralist.model

import com.aurora.carevision.domain.admin.model.camera.Camera
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AdminCameraListResponse(
    @SerialName("cameraInfoList")
    val cameraInfoList: List<CameraInfo> = emptyList(),
    @SerialName("totalCount")
    val totalCount: Int = 0
) {
    @Serializable
    data class CameraInfo(
        @SerialName("cameraId")
        val cameraId: String,
        @SerialName("inpatientWardNumber")
        val inpatientWardNumber: Int,
        @SerialName("patientRoomNumber")
        val patientRoomNumber: Int,
        @SerialName("bedNumber")
        val bedNumber: Int
    )
}

fun AdminCameraListResponse.toDomainModel(): List<Camera> {
    return cameraInfoList.map{
        Camera(
            cameraId = it.cameraId,
            inpatientWardNumber = it.inpatientWardNumber,
            patientRoomNumber = it.patientRoomNumber,
            bedNumber = it.bedNumber
        )
    }
}