package com.aurora.carevision.app

import com.aurora.carevision.R
import com.aurora.carevision.feature.admin.home.AdminListScreen
import com.aurora.carevision.feature.admin.home.navigation.AdminHome
import com.aurora.carevision.feature.admin.request.AdminRequestAcceptance
import com.aurora.carevision.feature.admin.request.AdminRequestAcceptanceScreen
import com.aurora.carevision.feature.nurse.home.navigation.NurseHome
import com.aurora.carevision.feature.nurse.mypage.NurseMypage
import com.aurora.carevision.feature.nurse.patient.info.PatientInfo
import com.aurora.carevision.feature.nurse.patient.registration.PatientRegistration

data class TopLevelRoute<T : Any>(val name: String, val route: T, val defaultIcon: Int)

val topLevelRoutes = listOf(
    TopLevelRoute("홈", NurseHome, R.drawable.ic_home_line),
    TopLevelRoute("환자 정보", PatientInfo, R.drawable.ic_patient_info_line),
    TopLevelRoute("내 정보", NurseMypage, R.drawable.ic_person_line),
)

val adminTopLevelRoutes = listOf(
    TopLevelRoute("홈", AdminHome, R.drawable.ic_home_line),
    TopLevelRoute("요청", AdminRequestAcceptance, R.drawable.ic_bell_bottom_navi_line),
)


