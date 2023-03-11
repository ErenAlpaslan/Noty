package com.easylife.noty.domain

import com.easylife.noty.data.entity.NoteUI
import com.easylife.noty.data.repository.NoteRepository
import com.easylife.noty.utils.dispatchers.NotyDispatchers
import com.easylife.noty.utils.result.NotyResult
import io.realm.kotlin.types.ObjectId
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by erenalpaslan on 23.02.2023
 */
class GetNoteUseCase(
    private val dispatchers: NotyDispatchers,
    private val noteRepository: NoteRepository
) : BaseUseCase<NoteUI, GetNoteUseCase.Param>() {

    data class Param(
        val id: String?
    )

    override suspend fun execute(params: Param): Flow<NotyResult<NoteUI>> = flow {
        try {
            val note = noteRepository.getNote(params.id)
            if (note != null) {
                val noteUI = NoteUI(
                    title = note.title,
                    content = note.content,
                    timestamp = note.timestamp,
                    id = note.id
                )
                emit(NotyResult.Success(noteUI))
            }else {
                emit(NotyResult.Error("Couldn't find related note"))
            }
        } catch (e: Exception) {
            emit(NotyResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)

}