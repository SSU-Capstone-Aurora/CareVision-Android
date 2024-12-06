package com.aurora.carevision.data.remote.nurse.fcm.datasource

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.fcm.model.FCMRequestBody
import com.aurora.carevision.data.remote.nurse.fcm.service.FirebaseTokenService
import com.aurora.carevision.data.remote.nurse.fcm.service.FirebaseTokenServiceResponse
import retrofit2.Call
import javax.inject.Inject

class DefaultNurseFCMDataSource @Inject constructor(
    private val firebaseTokenService: FirebaseTokenService
): NurseFCMDataSource {
    override fun sendRegistrationToken(fcmRequestBody: FCMRequestBody): Call<FirebaseTokenServiceResponse> {
        return firebaseTokenService.sendRegistrationToken(fcmRequestBody)
    }
}