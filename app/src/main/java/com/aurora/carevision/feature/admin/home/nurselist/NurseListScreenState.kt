package com.aurora.carevision.feature.admin.home.nurselist

import com.aurora.carevision.domain.admin.model.nurse.NurseList

data class NurseListScreenState(
    val nurses: List<NurseList> = emptyList(),
)