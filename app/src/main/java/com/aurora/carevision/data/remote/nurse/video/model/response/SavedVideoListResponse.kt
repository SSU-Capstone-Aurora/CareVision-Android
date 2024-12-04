package com.aurora.carevision.data.remote.nurse.video.model.response

import com.aurora.carevision.domain.nurse.model.streaming.SavedVideoInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SavedVideoListResponse(
    @SerialName("videoInfoList")
    val savedVideoList: List<SavedVideo>,
    @SerialName("totalCount")
    val totalCount: Int
) {
    @Serializable
    data class SavedVideo(
        @SerialName("videoId")
        val videoId: Int,
        @SerialName("thumbnail")
        val thumbnail: String,
        @SerialName("name")
        val videoDate: String,
        @SerialName("length")
        val videoLength: String?,
    )
}

fun SavedVideoListResponse.toDomainModel(): List<SavedVideoInfo> {
    return savedVideoList.map {
        SavedVideoInfo(
            videoId = it.videoId,
            thumbnail = it.thumbnail,
            videoDate = it.videoDate,
            videoLength = it.videoLength ?: "0:00"
        )
    }
}