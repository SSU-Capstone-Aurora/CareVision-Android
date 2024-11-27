package com.aurora.carevision.feature.admin.home.nurselist

import com.aurora.carevision.feature.nurse.auth.signup.NurseSignUpSideEffect

sealed class NurseListScreenSideEffect {
    data class ShowToast(val message: String) : NurseListScreenSideEffect()

    object loadSuccess : NurseListScreenSideEffect()
}