package com.aurora.carevision.feature.nurse.auth.signup

sealed class NurseSignUpSideEffect {
    object NavigateToHome : NurseSignUpSideEffect()
    object NavigateToNext : NurseSignUpSideEffect()
    object NavigateToBack : NurseSignUpSideEffect()
}
