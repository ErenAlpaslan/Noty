package com.easylife.noty.feature.splash.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes.splashRoute
import com.google.accompanist.navigation.animation.composable
import com.easylife.noty.feature.splash.SplashScreen

/**
 * Created by erenalpaslan on 23.12.2022
 */
fun NavController.navigateToSplash(navOptions: NavOptions? = null) {
    this.navigate(splashRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.splashScreen(navigator: NotyNavigator) {
    composable(route = splashRoute) {
        SplashScreen().Create(
            navigator = navigator,
            viewModel = hiltViewModel()
        )
    }
}