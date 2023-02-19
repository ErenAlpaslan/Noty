package com.easylife.noty.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.realm.kotlin.Realm

/**
 * Created by erenalpaslan on 19.12.2022
 */
@HiltAndroidApp
class NotyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}