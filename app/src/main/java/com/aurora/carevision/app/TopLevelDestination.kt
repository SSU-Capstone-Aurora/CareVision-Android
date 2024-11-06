package com.aurora.carevision.app

import com.aurora.carevision.R
import com.aurora.carevision.feature.nurse.home.navigation.NurseHome
import com.aurora.carevision.feature.nurse.mypage.NurseMypage
import com.aurora.carevision.feature.nurse.patient.info.PatientInfo
import com.aurora.carevision.feature.nurse.patient.registration.PatientRegistration

data class TopLevelRoute<T : Any>(val route: T, val defaultIcon: Int, val selectedIcon: Int)

val topLevelRoutes = listOf(
    TopLevelRoute(NurseHome, R.drawable.ic_home_line, R.drawable.ic_home_filled),
    TopLevelRoute(PatientInfo, R.drawable.ic_patient_info_line, R.drawable.ic_patient_info_filled),
    TopLevelRoute(
        PatientRegistration,
        R.drawable.ic_patient_register_line,
        R.drawable.ic_patient_register_filled
    ),
    TopLevelRoute(NurseMypage, R.drawable.ic_person_line, R.drawable.ic_person_filled),
)



