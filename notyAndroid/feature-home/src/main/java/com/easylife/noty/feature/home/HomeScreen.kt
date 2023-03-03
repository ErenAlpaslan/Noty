package com.easylife.noty.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.easylife.noty.core.designsystem.base.BaseScreen
import com.easylife.noty.core.designsystem.components.NotyTopBar
import com.easylife.noty.core.designsystem.components.SearchTextField
import com.easylife.noty.core.designsystem.components.note.NoteView
import com.easylife.noty.data.entity.Note
import com.easylife.noty.data.entity.NoteUI

/**
 * Created by erenalpaslan on 10.02.2023
 */
class HomeScreen : BaseScreen<HomeViewModel>() {
    @Composable
    override fun Screen() {
        val notes by viewModel.notes.collectAsStateWithLifecycle()

        Content(
            notes = notes
        )
    }

    @Composable
    fun Content(
        notes: List<NoteUI>
    ) {
        Scaffold(
            topBar = {
                NotyTopBar(
                    title = "Noty",
                    actions = {
                        IconButton(onClick = { /*TODO More button clicked*/ }) {
                            Icon(
                                imageVector = Icons.Rounded.MoreVert,
                                contentDescription = "More Icon"
                            )
                        }
                    },
                    divider = {
                        Divider(modifier = Modifier.padding(horizontal = 16.dp))
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                SearchTextField(
                    placeholder = {
                        Text(text = "Search notes...")
                    }
                ) {searchText ->
                    viewModel.onSearchTextChanged(searchText)
                }

                NoteView(list = notes) {
                    viewModel.onNoteClicked(it)
                }
            }
        }
    }
}