package com.easylife.noty.data.repository

import com.easylife.noty.data.database.dao.NoteDao
import com.easylife.noty.data.entity.Note
import com.easylife.noty.data.entity.NoteUI
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.find

/**
 * Created by erenalpaslan on 19.02.2023
 */
class NoteRepository(
    private val realm: Realm
): NoteDao {

    override suspend fun getNotes(): List<Note> {
        return realm.query(Note::class).find().toList()
    }

    override suspend fun addNote(title: String?, content: String?) {
        realm.writeBlocking {
            copyToRealm(Note().apply {
                this.title = title
                this.content = content
                this.timestamp
            })
        }
    }

    override suspend fun deleteNote(note: NoteUI) {
        realm.write {
            this.query<Note>("id == $0", note.id).find().firstOrNull()?.let {
                delete(it)
            }
        }
    }

    override suspend fun getNote(id: String?): Note? {
        return realm.query(Note::class).find().firstOrNull { it.id.toString() == id }
    }

    override suspend fun updateNote(note: NoteUI) {
        realm.write {
            val _note: Note? =
                this.query<Note>("id == $0", note.id).first().find()
            // modify the frog's age in the write transaction to persist the new age to the realm
            _note?.content = note.content
            _note?.title = note.title
        }
    }
}