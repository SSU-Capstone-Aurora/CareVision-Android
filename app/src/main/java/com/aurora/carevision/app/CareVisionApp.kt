package com.aurora.carevision.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CareVisionApp : Application() {
    override fun onCreate() {
        super.onCreate()

    }
}