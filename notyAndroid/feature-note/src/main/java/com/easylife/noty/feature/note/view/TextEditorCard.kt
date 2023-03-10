package com.easylife.noty.feature.note.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/**
 * Created by erenalpaslan on 11.02.2023
 */
@Composable
fun TextEditorCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = CircleShape,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.ic_smallcaps), contentDescription = "icon")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.ic_text_bold), contentDescription = "icon")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.ic_gallery), contentDescription = "icon")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.ic_microphone), contentDescription = "icon")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.ic_more_circle), contentDescription = "icon")
            }
        }
    }
}
