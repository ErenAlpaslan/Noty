package com.easylife.noty.feature.note

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.text.HtmlCompat
import com.easylife.noty.core.designsystem.base.BaseScreen
import com.easylife.noty.core.designsystem.components.NotyBasicTextField
import com.easylife.noty.core.designsystem.components.NotyTopBar
import com.easylife.noty.core.designsystem.theme.red
import com.easylife.noty.feature.note.view.TextEditorCard

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
        val uiState by viewModel.uiState.collectAsState()

        val title = remember {
            mutableStateOf<String?>("")
        }

        val text = remember {
            mutableStateOf<String?>("")
        }

        LaunchedEffect(key1 = viewModel.noteUI) {
            title.value = viewModel.noteUI?.title
            text.value = viewModel.noteUI?.content
        }

        LaunchedEffect(key1 = uiState) {
            text.value = uiState.content
        }

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
                        TextButton(onClick = {
                            viewModel.onDeleteClicked()
                        }) {
                            Text(text = "Delete", color = red)
                        }

                        TextButton(onClick = {
                            viewModel.onSaveClicked()
                        }) {
                            Text(text = "Save")
                        }
                    }
                )
            }
        )
        {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding())
                    .imePadding()
            ) {
                val (dateRef, titleRef, contentRef, editorRef) = createRefs()
                Text(
                    text = "18 Jan 1997 20:07",
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.constrainAs(dateRef) {
                        start.linkTo(parent.start, 16.dp)
                        end.linkTo(parent.end, 16.dp)
                        top.linkTo(parent.top)
                        width = Dimension.fillToConstraints
                    }
                )
                NotyBasicTextField(
                    text = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(0.dp, 0.dp)
                        .constrainAs(titleRef) {
                            top.linkTo(dateRef.bottom)
                            start.linkTo(parent.start, 16.dp)
                            end.linkTo(parent.end, 16.dp)
                            width = Dimension.fillToConstraints
                        },
                    textStyle = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    placeholder = viewModel.noteUI?.title ?: "Title",
                    singleLine = true,
                ) {
                    viewModel.onTitleChanged(it)
                }
                NotyBasicTextField(
                    text = text,
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(contentRef) {
                            top.linkTo(titleRef.bottom, 16.dp)
                            start.linkTo(parent.start, 16.dp)
                            end.linkTo(parent.end, 16.dp)
                            bottom.linkTo(editorRef.top, 8.dp)
                            width = Dimension.fillToConstraints
                            height = Dimension.fillToConstraints
                        },
                    placeholder = "Content here...",
                    textStyle = MaterialTheme.typography.bodyLarge,
                    isHtml = true
                ) {
                    viewModel.onContentChanged(it)
                }
                TextEditorCard(modifier = Modifier
                    .constrainAs(editorRef) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                )
            }
        }
    }
}