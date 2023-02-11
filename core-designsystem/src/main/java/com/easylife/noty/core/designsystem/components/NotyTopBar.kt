package com.easylife.noty.core.designsystem.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by erenalpaslan on 11.02.2023
 */
@Composable
fun NotyTopBar(
    title: String,
    actions: @Composable RowScope.() -> Unit = {},
    navigationIcon: @Composable () -> Unit = {},
    divider: @Composable () -> Unit = {}
) {
    Column {
        TopAppBar(
            title = {
                Text(text = title)
            },
            actions = {
                actions()
            },
            navigationIcon = {
                navigationIcon()
            }
        )
        divider()
    }
}