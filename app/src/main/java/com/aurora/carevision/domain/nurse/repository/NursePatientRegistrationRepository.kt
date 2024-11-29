package com.aurora.carevision.domain.nurse.repository

interface NursePatientRegistrationRepository {
    suspend fun getRegistrationPatientName(patientCode: String): String
}