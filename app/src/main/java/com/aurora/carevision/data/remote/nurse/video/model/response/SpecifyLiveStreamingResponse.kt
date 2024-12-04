package com.aurora.carevision.data.remote.nurse.video.model.response

import com.aurora.carevision.domain.nurse.model.streaming.StreamingSpecifyPatientInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpecifyLiveStreamingResponse(
    @SerialName("url")
    val url: String,
    @SerialName("patientName")
    val patientName: String,
    @SerialName("bedInfo")
    val bedInfo: BedInfo,
) {
    @Serializable
    data class BedInfo(
        @SerialName("inpatientWardNumber")
        val inpatientWardNumber: Int,
        @SerialName("patientRoomNumber")
        val patientRoomNumber: Int,
        @SerialName("bedNumber")
        val bedNumber: Int,
    )
}

fun SpecifyLiveStreamingResponse.toDomainModel(): StreamingSpecifyPatientInfo {
    return StreamingSpecifyPatientInfo(
        patientName = patientName,
        bedNumber = bedInfo.bedNumber,
        inpatientWardNumber = bedInfo.inpatientWardNumber,
        patientRoomNumber = bedInfo.patientRoomNumber,
        liveStreamingUrl = url,
    )
}