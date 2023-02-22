package com.easylife.noty.android.ui.screen.main

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 22.02.2023
 */
val mainModule = module {
    viewModelOf(::MainViewModel)
}
