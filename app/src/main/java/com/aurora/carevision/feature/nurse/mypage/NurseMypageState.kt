package com.aurora.carevision.feature.nurse.mypage

data class NurseMypageState(
    val isLoading: Boolean = false,
    val nurseName: String = "",
    val registeredAt: String? = "",
    val hospitalName: String = "",
    val department: String = "",
    val error: String = ""
)