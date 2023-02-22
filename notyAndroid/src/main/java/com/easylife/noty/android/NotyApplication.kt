package com.easylife.noty.android

import android.app.Application
import com.easylife.feature.premium.premiumModule
import com.easylife.noty.android.ui.screen.main.mainModule
import com.easylife.noty.core.navigation.navigationModule
import com.easylife.noty.di.appModules
import com.easylife.noty.feature.home.homeModule
import com.easylife.noty.feature.note.noteModule
import com.easylife.noty.feature.settings.settingsModule
import com.easylife.noty.feature.splash.splashModule
import com.easylife.noty.feature_category.categoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by erenalpaslan on 19.12.2022
 */
class NotyApplication: Application() {

    private val moduleList = listOf(
        navigationModule,
        categoryModule,
        homeModule,
        noteModule,
        premiumModule,
        settingsModule,
        splashModule,
        mainModule
    )
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@NotyApplication)
            modules(appModules() + moduleList)
        }
    }
}