package com.easylife.noty.feature.home

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 22.02.2023
 */
val homeModule = module {
    viewModelOf(::HomeViewModel)
}
