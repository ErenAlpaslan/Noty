package com.easylife.noty.domain

import com.easylife.noty.data.repository.NoteRepository
import com.easylife.noty.utils.dispatchers.NotyDispatchers
import com.easylife.noty.utils.result.NotyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by erenalpaslan on 19.02.2023
 */
class AddNoteUseCase(
    private val dispatchers: NotyDispatchers,
    private val noteRepository: NoteRepository
) : BaseUseCase<Boolean, AddNoteUseCase.Param>() {

    data class Param(
        val title: String?,
        val content: String?,
    )

    override suspend fun execute(params: Param): Flow<NotyResult<Boolean>> = flow {
        try {
            noteRepository.addNote(params.title, params.content)
            emit(NotyResult.Success(true))
        } catch (e: Exception) {
            emit(NotyResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)

}