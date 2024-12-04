package com.aurora.carevision.data.remote.nurse.video.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SavedVideoUrlResponse(
    @SerialName("link")
    val link: String
)