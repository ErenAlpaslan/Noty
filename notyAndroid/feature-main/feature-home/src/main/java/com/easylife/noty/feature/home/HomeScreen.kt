package com.easylife.noty.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.easylife.noty.core.designsystem.base.BaseScreen

/**
 * Created by erenalpaslan on 10.02.2023
 */
class HomeScreen: BaseScreen<HomeViewModel>() {
    @Composable
    override fun Screen() {
        Content()
    }

    @Composable
    fun Content() {
        Scaffold(
            topBar = {
                Column {
                    TopAppBar(
                        title = {
                            Text(text = "Noty")
                        },
                        actions = {
                            IconButton(onClick = { /*TODO More button clicked*/ }) {
                                Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "More Icon")
                            }
                        }
                    )
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
            }
        ) {paddingValues ->
            Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {

            }
        }
    }
}