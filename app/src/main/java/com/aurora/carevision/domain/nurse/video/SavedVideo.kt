package com.aurora.carevision.domain.nurse.video

data class SavedVideo(
    val videoId: Int,
    val videoUrl: String,
    val videoThumbnail: String,
    val videoPlayTime: String,
    val videoDate: String,
)