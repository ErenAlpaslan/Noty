package com.easylife.noty.core.designsystem.components.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.easylife.noty.core.designsystem.R
import com.easylife.noty.core.designsystem.theme.azure
import com.easylife.noty.core.designsystem.theme.green
import com.easylife.noty.core.designsystem.theme.red

/**
 * Created by erenalpaslan on 11.02.2023
 */
@Composable
fun CategoryList(
    list: List<Pair<String, Color>> = listOf(
        "Project; re" to red,
        "Food recipes" to green,
        "Referral code" to azure
    ),
    onCategoryClicked: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(list) {
            CategoryItem(it)
        }
    }
}

@Composable
fun CategoryItem(pair: Pair<String, Color>) {
    Card(
        onClick = {

        },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_folder_open),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(pair.second),
                    modifier = Modifier
                        .size(64.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "More")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = pair.first,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "10 Notes",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}