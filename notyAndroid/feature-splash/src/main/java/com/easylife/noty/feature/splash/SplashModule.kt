package com.easylife.noty.feature.splash

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 22.02.2023
 */
val splashModule = module {
    viewModel { SplashViewModel(get()) }
}