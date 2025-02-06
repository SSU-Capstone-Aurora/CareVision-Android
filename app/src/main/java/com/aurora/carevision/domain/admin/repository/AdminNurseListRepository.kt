package com.aurora.carevision.domain.admin.repository

import com.aurora.carevision.domain.admin.model.nurse.NurseInfo

interface AdminNurseListRepository {
    suspend fun getNurseList(): List<NurseInfo>
}