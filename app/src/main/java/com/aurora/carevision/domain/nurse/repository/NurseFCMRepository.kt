package com.aurora.carevision.domain.nurse.repository

interface NurseFCMRepository {
    fun sendRegistrationToken(username: String, clientToken: String)
}