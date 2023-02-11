package com.easylife.noty.feature.home.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Created by erenalpaslan on 11.02.2023
 */
@Composable
fun SearchTextField(
    onTextChanged: (String?) -> Unit
) {
    var text by remember {
        mutableStateOf("")
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        placeholder = {
            Text(text = "Search notes...")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp),
        singleLine = true,
        maxLines = 1
    )
}