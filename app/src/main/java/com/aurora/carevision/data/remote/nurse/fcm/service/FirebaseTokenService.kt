package com.aurora.carevision.data.remote.nurse.fcm.service

import com.aurora.carevision.data.remote.nurse.fcm.model.FCMRequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface FirebaseTokenService {
    @POST("api/fcm/registeration-token")
    fun sendRegistrationToken(@Body fcmRequestBody: FCMRequestBody): Call<FirebaseTokenServiceResponse>
}

@Serializable
data class FirebaseTokenServiceResponse(
    @SerialName("isSuccess")
    val isSuccess: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("code")
    val code: String
)