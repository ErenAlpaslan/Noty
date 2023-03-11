package com.easylife.noty.data.repository

import com.easylife.noty.data.database.dao.NoteDao
import com.easylife.noty.data.entity.Note
import com.easylife.noty.data.entity.NoteUI
import io.realm.kotlin.Realm
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
            val dbNote = this.query(Note::class, "id == ${note.id}").find().first()
            delete(dbNote)
        }
    }

    override suspend fun getNote(id: String?): Note? {
        return realm.query(Note::class).find().firstOrNull { it.id.toString() == id }
    }
}