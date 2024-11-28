package com.aurora.carevision.feature.nurse.patient.info

import com.aurora.carevision.domain.nurse.model.Patient

data class PatientInfoState(
    val patientInfoList: List<Patient> = emptyList(),
)