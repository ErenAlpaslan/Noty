package com.easylife.feature.premium.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import com.easylife.feature.premium.PremiumScreen
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 11.02.2023
 */
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.premiumScreen(navigator: NotyNavigator) {
    composable(route = NotyRoutes.premiumRoute) {
        PremiumScreen().Create(
            navigator = navigator,
            viewModel = hiltViewModel()
        )
    }
}