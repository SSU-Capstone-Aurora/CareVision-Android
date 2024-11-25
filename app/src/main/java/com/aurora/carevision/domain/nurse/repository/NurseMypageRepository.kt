package com.aurora.carevision.domain.nurse.repository

import com.aurora.carevision.domain.nurse.model.mypage.NurseMypage

interface NurseMypageRepository {
    suspend fun getNurseMypage(): NurseMypage
}