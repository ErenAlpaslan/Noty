package com.easylife.noty.feature.home.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes
import com.easylife.noty.feature.home.HomeScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 10.02.2023
 */
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeScreen(navigator: NotyNavigator) {
    composable(route = NotyRoutes.homeRoute) {
        HomeScreen().Create(
            navigator = navigator,
            viewModel = hiltViewModel()
        )
    }
}