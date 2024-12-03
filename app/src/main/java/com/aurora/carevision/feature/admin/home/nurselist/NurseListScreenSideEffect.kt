package com.aurora.carevision.feature.admin.home.nurselist

import com.aurora.carevision.feature.nurse.auth.signup.NurseSignUpSideEffect

sealed class NurseListScreenSideEffect {
    object GetNurseListSuccess : NurseListScreenSideEffect()
    object GetNurseListFailure : NurseListScreenSideEffect()}