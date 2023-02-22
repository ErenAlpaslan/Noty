package com.easylife.noty.domain

import com.easylife.noty.utils.result.NotyResult
import kotlinx.coroutines.flow.Flow

/**
 * Created by erenalpaslan on 19.02.2023
 */
abstract class BaseUseCase<T, R>() {
    abstract suspend fun execute(params: R): Flow<NotyResult<T>>
}