package com.aurora.carevision.domain.admin.repository

import com.aurora.carevision.domain.admin.model.nurse.NurseList

interface AdminNurseListRepository {
    suspend fun getNurseList(): List<NurseList>
}