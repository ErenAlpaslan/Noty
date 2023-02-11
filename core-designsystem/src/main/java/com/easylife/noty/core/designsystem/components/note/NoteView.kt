package com.easylife.noty.core.designsystem.components.note

import androidx.compose.runtime.Composable

/**
 * Created by erenalpaslan on 11.02.2023
 */
@Composable
fun NoteView(
    list: List<String>,
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