package com.easylife.noty.core.designsystem.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

/**
 * Created by erenalpaslan on 11.02.2023
 */
@Composable
fun NotyTopBar(
    title: String? = null,
    actions: @Composable RowScope.() -> Unit = {},
    navigationIcon: @Composable () -> Unit = {},
    divider: @Composable () -> Unit = {}
) {
    Column {
        TopAppBar(
            title = {
                if (!title.isNullOrEmpty()) {
                    Text(text = title)
                }
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