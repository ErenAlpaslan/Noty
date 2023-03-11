package com.easylife.noty.domain

import com.easylife.noty.data.entity.NoteUI
import com.easylife.noty.data.repository.NoteRepository
import com.easylife.noty.utils.dispatchers.NotyDispatchers
import com.easylife.noty.utils.result.NotyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by erenalpaslan on 23.02.2023
 */
class DeleteNoteUseCase(
    private val dispatchers: NotyDispatchers,
    private val noteRepository: NoteRepository
) : BaseUseCase<Boolean, DeleteNoteUseCase.Param>() {

    data class Param(
        val note: NoteUI
    )

    override suspend fun execute(params: Param): Flow<NotyResult<Boolean>> = flow {
        try {
            noteRepository.deleteNote(params.note)
            emit(NotyResult.Success(true))
        }catch (e: Exception) {
            emit(NotyResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)


}