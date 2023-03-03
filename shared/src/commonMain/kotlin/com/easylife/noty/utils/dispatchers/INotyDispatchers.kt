package com.easylife.noty.utils.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher

/**
 * Created by erenalpaslan on 19.02.2023
 */
interface INotyDispatchers {
    val main: MainCoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}