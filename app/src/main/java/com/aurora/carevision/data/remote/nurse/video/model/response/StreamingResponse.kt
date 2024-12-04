package com.aurora.carevision.data.remote.nurse.video.model.response

import com.aurora.carevision.domain.nurse.model.streaming.PatientStreamingInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StreamingResponse(
    @SerialName("streamingResponse")
    val streamingResponse: List<StreamingResponseItem>,
    @SerialName("totalCount")
    val totalCount: Int
){
    @Serializable
    data class StreamingResponseItem(
        @SerialName("patientId")
        val patientId: Int,
        @SerialName("patientName")
        val patientName: String,
        @SerialName("thumbnail")
        val thumbnail: String,
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
}

fun StreamingResponse.toDomainModel(): List<PatientStreamingInfo> {
    return streamingResponse.map {
        PatientStreamingInfo(
            patientId = it.patientId,
            patientName = it.patientName,
            thumbnailImage = it.thumbnail,
            bedNumber = it.bedInfo.bedNumber,
            inpatientWardNumber = it.bedInfo.inpatientWardNumber,
            patientRoomNumber = it.bedInfo.patientRoomNumber,
            liveStreamingUrl = ""
        )
    }
}