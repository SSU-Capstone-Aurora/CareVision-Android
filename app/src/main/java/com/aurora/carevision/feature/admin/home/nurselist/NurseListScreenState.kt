package com.aurora.carevision.feature.admin.home.nurselist

import com.aurora.carevision.domain.admin.model.nurse.NurseInfo

data class NurseListScreenState(
    val nurseList: List<NurseInfo> = emptyList(),
)