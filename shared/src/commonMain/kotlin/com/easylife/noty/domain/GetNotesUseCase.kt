package com.easylife.noty.domain

import com.easylife.noty.data.entity.Note
import com.easylife.noty.data.entity.NoteUI
import com.easylife.noty.data.repository.NoteRepository
import com.easylife.noty.utils.dispatchers.NotyDispatchers
import com.easylife.noty.utils.result.NotyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by erenalpaslan on 22.02.2023
 */
class GetNotesUseCase(
    private val dispatchers: NotyDispatchers,
    private val noteRepository: NoteRepository
) : BaseUseCase<List<NoteUI>, Unit>() {

    override suspend fun execute(params: Unit): Flow<NotyResult<List<NoteUI>>> = flow {
        try {
            val notes = noteRepository.getNotes()
            emit(NotyResult.Success(notes.map {
                NoteUI(
                    title = it.title,
                    content = it.content,
                    timestamp = it.timestamp,
                    id = it.id
                )
            }))
        } catch (e: Exception) {
            emit(NotyResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)

}