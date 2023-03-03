package com.easylife.noty.utils.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher

/**
 * Created by erenalpaslan on 19.02.2023
 */
actual class NotyDispatchers: INotyDispatchers {
    override val main: MainCoroutineDispatcher
        get() = Dispatchers.Main
    override val io: CoroutineDispatcher
        get() = Dispatchers.Default
    override val default: CoroutineDispatcher
        get() = Dispatchers.Default
}