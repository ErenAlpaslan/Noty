package com.easylife.noty.android.ui.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/**
 * Created by erenalpaslan on 11.02.2023
 */
@Composable
fun NotyFab(
    onAddNoteClicked: () -> Unit,
    onAddCategoryClicked: () -> Unit
) {
    var visible by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically {
                // Slide in from 40 dp from the top.
                with(density) { 40.dp.roundToPx() }
            } + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically {
                with(density) { 40.dp.roundToPx() }
            } + fadeOut()
        ) {
            Column(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .wrapContentHeight()
            ) {
                IconButton(
                    onClick = { onAddCategoryClicked() },
                    colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.primary)
                ) {
                    Icon(
                        painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.ic_folder_add),
                        contentDescription = ""
                    )
                }
                IconButton(
                    onClick = { onAddNoteClicked() },
                    colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.primary),
                ) {
                    Icon(
                        painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.ic_note_add),
                        contentDescription = ""
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        FloatingActionButton(
            onClick = {
                visible = visible.not()
            },
            shape = CircleShape,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "Add"
            )
        }
    }
}