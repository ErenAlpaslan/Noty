package com.easylife.noty.core.common.util.dispatchers

import com.easylife.noty.core.common.util.dispatchers.INotyDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class NotyDispatchers: INotyDispatchers() {
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val default: CoroutineDispatcher
        get() = Dispatchers.Default
}