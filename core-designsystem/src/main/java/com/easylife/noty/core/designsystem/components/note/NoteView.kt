package com.easylife.noty.core.designsystem.components.note

import androidx.compose.runtime.Composable
import com.easylife.noty.data.entity.NoteUI

/**
 * Created by erenalpaslan on 11.02.2023
 */
@Composable
fun NoteView(
    list: List<NoteUI>,
    onClick: (String) -> Unit
) {
    if (list.isNotEmpty()) {
        NoteList(list = list) {
            onClick(it)
        }
    }else {
        NoteEmptyView()
    }
}