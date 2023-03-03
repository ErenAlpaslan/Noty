package com.easylife.noty.utils.dispatchers

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 19.02.2023
 */
expect class NotyDispatchers actual constructor(): INotyDispatchers

val dispatcherModule = module {
    singleOf(::NotyDispatchers)
}