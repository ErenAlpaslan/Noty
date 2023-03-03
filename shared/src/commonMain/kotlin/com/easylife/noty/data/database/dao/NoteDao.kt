package com.easylife.noty.data.database.dao

import com.easylife.noty.data.entity.Note

/**
 * Created by erenalpaslan on 19.02.2023
 */
interface NoteDao {

    suspend fun getNotes(): List<Note>

    suspend fun addNote(title: String?, content: String?)

    suspend fun deleteNote(note: Note)

}