package com.aurora.carevision.feature.admin.home.nurselist

import com.aurora.carevision.data.remote.admin.nurselist.model.NurseListResponse
import com.aurora.carevision.domain.admin.model.nurserequest.NurseList

data class NurseListScreenState(
    val nurses: List<NurseListResponse.NurseResponse> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)