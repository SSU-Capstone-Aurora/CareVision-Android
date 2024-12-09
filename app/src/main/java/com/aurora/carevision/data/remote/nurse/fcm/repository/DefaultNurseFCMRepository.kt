package com.aurora.carevision.data.remote.nurse.fcm.repository

import com.aurora.carevision.data.remote.nurse.fcm.datasource.NurseFCMDataSource
import com.aurora.carevision.data.remote.nurse.fcm.service.FirebaseTokenService
import com.aurora.carevision.data.remote.nurse.fcm.model.toDateModel
import com.aurora.carevision.domain.nurse.model.notification.FCMToken
import com.aurora.carevision.domain.nurse.repository.NurseFCMRepository
import javax.inject.Inject

class DefaultNurseFCMRepository @Inject constructor(
    private val nurseFCMDataSource: NurseFCMDataSource
): NurseFCMRepository {


    override fun sendRegistrationToken(username: String, clientToken: String) {
        val fcmToken = FCMToken(username, clientToken)
        val fcmRequestBody = fcmToken.toDateModel()
        nurseFCMDataSource.sendRegistrationToken(fcmRequestBody)
    }
}