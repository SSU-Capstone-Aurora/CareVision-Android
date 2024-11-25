package com.aurora.carevision.feature.nurse.mypage

sealed class NurseMypageSideEffect {
    object GetNurseMypageSuccess: NurseMypageSideEffect()
    object GetNurseMypageFailure: NurseMypageSideEffect()
}