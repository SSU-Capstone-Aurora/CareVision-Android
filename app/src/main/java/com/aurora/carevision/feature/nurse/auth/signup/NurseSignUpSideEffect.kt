package com.aurora.carevision.feature.nurse.auth.signup

sealed class NurseSignUpSideEffect {
    object NavigateToName : NurseSignUpSideEffect()
    object NavigateToIdPw : NurseSignUpSideEffect()
    object NavigateToWaiting : NurseSignUpSideEffect()
    object NavigateToHome : NurseSignUpSideEffect()
    object NavigateToInitialLogin : NurseSignUpSideEffect()
}
