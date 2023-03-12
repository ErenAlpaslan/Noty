package com.easylife.noty.data.database.dao

import com.easylife.noty.data.entity.Note
import com.easylife.noty.data.entity.NoteUI

/**
 * Created by erenalpaslan on 19.02.2023
 */
interface NoteDao {

    suspend fun getNotes(): List<Note>

    suspend fun addNote(title: String?, content: String?)

    suspend fun deleteNote(note: NoteUI)

    suspend fun getNote(id: String?): Note?

    suspend fun updateNote(note: NoteUI)

}