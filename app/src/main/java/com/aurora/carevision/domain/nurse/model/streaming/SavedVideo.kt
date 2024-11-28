package com.aurora.carevision.domain.nurse.model.streaming

data class SavedVideo(
    val videoId: Int,
    val videoUrl: String,
    val videoThumbnail: String,
    val videoPlayTime: String,
    val videoDate: String,
)