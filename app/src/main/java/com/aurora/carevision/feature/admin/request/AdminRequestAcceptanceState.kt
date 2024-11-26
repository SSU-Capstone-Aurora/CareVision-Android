package com.aurora.carevision.feature.admin.request

import com.aurora.carevision.domain.admin.model.nurserequest.NurseRequestList

data class AdminRequestAcceptanceState(
    val requestCount: Int = 0,
    val requests: List<NurseRequestList.NurseRequest> = emptyList()
)