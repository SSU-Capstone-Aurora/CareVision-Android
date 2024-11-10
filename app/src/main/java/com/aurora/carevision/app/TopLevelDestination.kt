package com.aurora.carevision.app

import com.aurora.carevision.R
import com.aurora.carevision.feature.nurse.home.navigation.NurseHome
import com.aurora.carevision.feature.nurse.mypage.NurseMypage
import com.aurora.carevision.feature.nurse.patient.info.PatientInfo
import com.aurora.carevision.feature.nurse.patient.registration.PatientRegistration

data class TopLevelRoute<T : Any>(val name: String, val route: T, val defaultIcon: Int)

val topLevelRoutes = listOf(
    TopLevelRoute("홈", NurseHome, R.drawable.ic_home_line),
    TopLevelRoute("환자 정보", PatientInfo, R.drawable.ic_patient_info_line),
    TopLevelRoute("환자 등록", PatientRegistration, R.drawable.ic_patient_register_line),
    TopLevelRoute("내 정보", NurseMypage, R.drawable.ic_person_line),
)



