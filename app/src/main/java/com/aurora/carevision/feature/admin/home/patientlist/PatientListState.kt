package com.aurora.carevision.feature.admin.home.patientlist

import com.aurora.carevision.domain.admin.model.patient.Patient

data class PatientListState (
    val patientList: List<Patient> = emptyList()
)