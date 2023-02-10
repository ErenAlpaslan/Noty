package com.easylife.noty.feature.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.easylife.noty.core.designsystem.base.BaseScreen

/**
 * Created by erenalpaslan on 11.02.2023
 */
class SettingsScreen: BaseScreen<SettingsViewModel>() {
    @Composable
    override fun Screen() {
        Scaffold(
            topBar = {
                Column {
                    TopAppBar(
                        title = {
                            Text(text = "Settings")
                        }
                    )
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
            }
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {

            }
        }
    }
}