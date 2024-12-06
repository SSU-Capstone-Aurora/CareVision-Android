package com.aurora.carevision.data.remote.nurse.fcm.datasource

import com.aurora.carevision.data.remote.nurse.fcm.model.FCMRequestBody
import com.aurora.carevision.data.remote.nurse.fcm.service.FirebaseTokenServiceResponse
import retrofit2.Call

interface NurseFCMDataSource {
    fun sendRegistrationToken(fcmRequestBody: FCMRequestBody): Call<FirebaseTokenServiceResponse>
}