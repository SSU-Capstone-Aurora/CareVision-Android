package com.aurora.carevision.feature.nurse.patient.registration.search

import com.aurora.carevision.domain.nurse.model.Patient

data class PatientRegistrationState (
    val patientList: List<Patient> = emptyList(),
    val selectedPatient: Patient? = null,
)