package com.easylife.noty.feature.note

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.easylife.noty.core.designsystem.base.BaseScreen
import com.easylife.noty.core.designsystem.components.NotyTopBar

/**
 * Created by erenalpaslan on 11.02.2023
 */
class NoteScreen : BaseScreen<NoteViewModel>() {
    @Composable
    override fun Screen() {
        Content()
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun Content() {
        Scaffold(
            topBar = {
                NotyTopBar(
                    navigationIcon = {
                        IconButton(onClick = { navigator.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBackIosNew,
                                contentDescription = "Back Arrow"
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                viewModel.onUndoClicked()
                            },
                            enabled = false
                        ) {
                            Icon(
                                painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.ic_undo),
                                contentDescription = "Undo"
                            )
                        }
                        IconButton(
                            onClick = {
                                viewModel.onRedoClicked()
                            },
                            enabled = false
                        ) {
                            Icon(
                                painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.ic_redo),
                                contentDescription = "Redo"
                            )
                        }
                        TextButton(onClick = {
                            viewModel.onSaveClicked()
                        }) {
                            Text(text = "Save")
                        }
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

            }
        }
    }
}