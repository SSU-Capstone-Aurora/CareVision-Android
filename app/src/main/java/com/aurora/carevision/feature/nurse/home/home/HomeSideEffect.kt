package com.aurora.carevision.feature.nurse.home.home

sealed class HomeSideEffect {
    object GetPatientStreamingListSuccess : HomeSideEffect()
    object GetPatientStreamingListFailure : HomeSideEffect()
    object GetSpecifyPatientStreamingUriSuccess : HomeSideEffect()
    object GetSpecifyPatientStreamingUriFailure : HomeSideEffect()
    object GetSavedVideosSuccess : HomeSideEffect()
    object GetSavedVideosFailure : HomeSideEffect()
    object GetSpecifyPatientSavedVideoUriSuccess : HomeSideEffect()
    object GetSpecifyPatientSavedVideoUriFailure : HomeSideEffect()
    object GetNotificationListSuccess : HomeSideEffect()
    object GetNotificationListFailure : HomeSideEffect()
    object GetNurseMypageSuccess : HomeSideEffect()
    object GetNurseMypageFailure : HomeSideEffect()
}