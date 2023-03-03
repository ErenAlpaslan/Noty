package com.easylife.noty.core.designsystem.components.note

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.easylife.noty.data.entity.NoteUI

/**
 * Created by erenalpaslan on 22.02.2023
 */
@Composable
fun NoteItem(note: NoteUI) {
    Text(text = "NOTE => ${note.title}\n${note.content}")
}