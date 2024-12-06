package com.aurora.carevision.data.remote.nurse.fcm.model

import com.aurora.carevision.domain.nurse.model.notification.FCMToken
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FCMRequestBody(
    @SerialName("username")
    val username: String,
    @SerialName("clientToken")
    val clientToken: String
)

fun FCMToken.toDateModel(): FCMRequestBody {
    return FCMRequestBody(
        username = this.username,
        clientToken = this.clientToken
    )
}