package com.aurora.carevision.feature.admin.request

import com.aurora.carevision.domain.admin.model.nurserequest.NurseRequestList

data class AdminRequestAcceptanceState(
    val requestCount: Int = 0,
    val requests: List<NurseRequestList.NurseRequest> = emptyList(),
    val isDialogVisible : Boolean = false,
    val selectedNurseId: Int = 0,
    val selectedNurseName: String? = null,
)

data class NurseRequest(
    val nurseId: Int,
    val name: String,
    val requestTime: String
)