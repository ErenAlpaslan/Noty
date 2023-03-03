package com.easylife.noty.android.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.easylife.noty.core.designsystem.theme.americanPink
import com.easylife.noty.core.designsystem.theme.azure
import com.easylife.noty.core.designsystem.theme.blue
import com.easylife.noty.core.designsystem.theme.darkGray
import com.easylife.noty.core.designsystem.theme.gold
import com.easylife.noty.core.designsystem.theme.green
import com.easylife.noty.core.designsystem.theme.red

/**
 * Created by erenalpaslan on 11.02.2023
 */
@Composable
fun CategorySheetContent(
    onSaveClicked: () -> Unit
) {
    var text by remember {
        mutableStateOf("")
    }
    val colors by remember {
        mutableStateOf(listOf(red, blue, gold, americanPink, green))
    }
    var selectedColorIndex by remember {
        mutableStateOf(-1)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(MaterialTheme.colorScheme.onBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Box() {
            Box(
                modifier = Modifier
                    .height(2.dp)
                    .width(24.dp)
                    .clip(CircleShape)
                    .background(darkGray)
                    .align(Alignment.Center)
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(end = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    onClick = {
                        onSaveClicked()
                    }
                ) {
                    Text(text = "Save")
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            placeholder = {
                Text(text = "Category name")
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
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            colors.forEachIndexed {index, color ->
                Box(modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(color)
                    .border(2.dp, if (selectedColorIndex == index) azure else Color.Transparent, CircleShape)
                    .clickable {
                        selectedColorIndex = index
                    }
                )
            }
        }

    }
}