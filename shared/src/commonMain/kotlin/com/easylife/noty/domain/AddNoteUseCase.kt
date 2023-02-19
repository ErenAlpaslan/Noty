package com.easylife.noty.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by erenalpaslan on 19.02.2023
 */
class AddNoteUseCase(

): BaseUseCase<Boolean, Unit>() {

    override suspend fun execute(params: Unit): Flow<NotyResult<Boolean>> = flow {

    }

}