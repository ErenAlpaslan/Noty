package com.easylife.noty.core.common.util.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

abstract class INotyDispatchers {

    abstract val main: CoroutineDispatcher

    abstract val io: CoroutineDispatcher

    abstract val default: CoroutineDispatcher
}