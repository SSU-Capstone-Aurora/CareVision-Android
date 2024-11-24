package com.aurora.carevision.feature.admin.auth.signup

import com.aurora.carevision.feature.admin.auth.signup.AdminSignUpHospitalEntrySideEffect

sealed class AdminSignUpHospitalEntrySideEffect {
    object NavigateNextScreen : AdminSignUpHospitalEntrySideEffect()
    object ShowError : AdminSignUpHospitalEntrySideEffect()
    data class PerformHospitalSearch(val query: String) : AdminSignUpHospitalEntrySideEffect()
    object NavigateToName : AdminSignUpHospitalEntrySideEffect()
    object NavigateToIdPw : AdminSignUpHospitalEntrySideEffect()
    object NavigateToWaiting : AdminSignUpHospitalEntrySideEffect()
    object NavigateToHome : AdminSignUpHospitalEntrySideEffect()
    object NavigateToInitialLogin : AdminSignUpHospitalEntrySideEffect()

    data class ShowToast(val message: String) : AdminSignUpHospitalEntrySideEffect()
    object SignUpSuccess : AdminSignUpHospitalEntrySideEffect()
}