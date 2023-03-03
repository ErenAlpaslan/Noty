package com.easylife.noty.feature.settings.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes
import com.easylife.noty.feature.settings.SettingsScreen
import com.google.accompanist.navigation.animation.composable
import org.koin.androidx.compose.getViewModel

/**
 * Created by erenalpaslan on 11.02.2023
 */
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.settingsScreen(navigator: NotyNavigator) {
    composable(route = NotyRoutes.settingsRoute) {
        SettingsScreen().Create(
            navigator = navigator,
            viewModel = getViewModel()
        )
    }
}