package com.ridhoafni.kmpmoviepedia

import android.app.Application
import com.ridhoafni.kmpmoviepedia.di.initKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}