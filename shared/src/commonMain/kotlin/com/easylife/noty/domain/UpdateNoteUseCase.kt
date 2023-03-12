package com.easylife.noty.domain

import com.easylife.noty.data.entity.NoteUI
import com.easylife.noty.data.repository.NoteRepository
import com.easylife.noty.utils.dispatchers.NotyDispatchers
import com.easylife.noty.utils.result.NotyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by erenalpaslan on 12.03.2023
 */
class UpdateNoteUseCase(
    private val dispatchers: NotyDispatchers,
    private val noteRepository: NoteRepository
): BaseUseCase<NoteUI, UpdateNoteUseCase.Param>() {

    data class Param(
        val noteUI: NoteUI
    )

    override suspend fun execute(params: Param): Flow<NotyResult<NoteUI>> = flow {
        try {
            noteRepository.updateNote(params.noteUI)
            emit(NotyResult.Success(params.noteUI))
        }catch (e: Exception) {
            emit(NotyResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)

}