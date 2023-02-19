package com.easylife.noty.core.designsystem.components

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.easylife.noty.core.designsystem.theme.azure

/**
 * Created by erenalpaslan on 18.02.2023
 */
@Composable
fun NotyBasicTextField(
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    singleLine: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    onValueChanged: (String?) -> Unit
) {
    var text by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = text,
        onValueChange = {
            text = it
            onValueChanged(it)
        },
        modifier = modifier,
        textStyle = textStyle.copy(color = MaterialTheme.colorScheme.onSurface),
        maxLines = if (singleLine) 1 else Int.MAX_VALUE,
        singleLine = singleLine,
        decorationBox = {
            if (text.isEmpty()) {
                Text(
                    text = placeholder ?: "",
                    style = textStyle
                )
            }else {
                it()
            }
        },
        cursorBrush = SolidColor(azure)
    )
}