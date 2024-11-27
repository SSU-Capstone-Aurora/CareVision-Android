package com.aurora.carevision.domain.admin.repository

import com.aurora.carevision.domain.admin.model.nurserequest.NurseRequestList

interface AdminNurseRequestRepository {
    suspend fun getNurseRequests(): NurseRequestList
    suspend fun acceptNurseRequests(nurseId: Int): Boolean
}