package com.easylife.noty.feature.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.easylife.noty.core.designsystem.base.BaseScreen
import com.easylife.noty.core.designsystem.components.NavigationButton
import com.easylife.noty.core.designsystem.components.NotyTopBar

/**
 * Created by erenalpaslan on 11.02.2023
 */
class SettingsScreen: BaseScreen<SettingsViewModel>() {
    @Composable
    override fun Screen() {
        Content()
    }

    @Composable
    fun Content() {
        val scrollableState = rememberScrollState()

        Scaffold(
            topBar = {
                NotyTopBar(
                    title = "Settings"
                )
            }
        ) { paddingValues ->
            Column(modifier = Modifier
                .verticalScroll(scrollableState)
                .padding(paddingValues)
            ) {
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    text = "GENERAL",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.labelMedium
                )
                NavigationButton(
                    title = "Notification",
                    icon = com.easylife.noty.core.designsystem.R.drawable.ic_notification
                ) {

                }
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                NavigationButton(
                    title = "Lock",
                    icon = com.easylife.noty.core.designsystem.R.drawable.ic_lock
                ) {
                }
                Spacer(modifier = Modifier.height(36.dp))
                Text(
                    text = "MY DATA",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.labelMedium
                )
                NavigationButton(
                    title = "Backup & Restore",
                    icon = com.easylife.noty.core.designsystem.R.drawable.ic_cloud_add
                ) {

                }
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                NavigationButton(
                    title = "Trash",
                    icon = com.easylife.noty.core.designsystem.R.drawable.ic_trash
                ) {

                }
                Spacer(modifier = Modifier.height(36.dp))
                Text(
                    text = "REMINDERS",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.labelMedium
                )
                NavigationButton(
                    title = "Daily logging reminder",
                    icon = com.easylife.noty.core.designsystem.R.drawable.ic_clock
                ) {

                }
                Spacer(modifier = Modifier.height(36.dp))
                Text(
                    text = "OTHER",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.labelMedium
                )
                NavigationButton(
                    title = "Share with friends",
                    icon = com.easylife.noty.core.designsystem.R.drawable.ic_export
                ) {
                    //ShareAppHelper.openShareApp(activity)
                }
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                NavigationButton(
                    title = "Help and Feedback",
                    icon = com.easylife.noty.core.designsystem.R.drawable.ic_message_question
                ) {

                }
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                NavigationButton(
                    title = "Remove ads",
                    icon = com.easylife.noty.core.designsystem.R.drawable.ic_remove_ad
                ) {

                }
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                NavigationButton(
                    title = "Rate app",
                    icon = com.easylife.noty.core.designsystem.R.drawable.ic_star
                ) {

                }
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                NavigationButton(
                    title = "Privacy policy",
                    icon = com.easylife.noty.core.designsystem.R.drawable.ic_shield_security
                ) {

                }
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.ic_layer),
                        contentDescription = "Navigation Button Icon",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "Version: 1.0.0",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(16.dp))
            }
        }
    }
}