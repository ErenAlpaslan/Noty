package com.easylife.noty.core.designsystem.components

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

/**
 * Created by erenalpaslan on 18.02.2023
 */
@Composable
fun NotyBasicTextField(
    modifier: Modifier = Modifier,
    placeholder: @Composable () -> Unit,
    singleLine: Boolean,
    textStyle: TextStyle = LocalTextStyle.current
) {
    var text by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = text,
        onValueChange = {
            text = it
        },
        modifier = modifier,
        textStyle = textStyle,
        maxLines = if (singleLine) 1 else Int.MAX_VALUE,
        singleLine = singleLine,
        decorationBox = {},
    )
}