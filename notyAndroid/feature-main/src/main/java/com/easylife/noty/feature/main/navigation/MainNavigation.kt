package com.easylife.noty.feature.main.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes
import com.easylife.noty.feature.home.navigation.homeScreen
import com.easylife.noty.feature.main.MainScreen
import com.easylife.noty.feature_category.navigation.categoryScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 10.02.2023
 */
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.mainScreen(navigator: NotyNavigator) {
    composable(route = NotyRoutes.splashRoute) {
        MainScreen().Create(
            navigator = navigator,
            viewModel = hiltViewModel()
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavHost(
    navigator: NotyNavigator,
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = NotyRoutes.homeRoute,
        modifier = Modifier.padding(
            bottom = paddingValues.calculateBottomPadding()
        )
    ) {
        homeScreen(navigator)
        categoryScreen(navigator)
    }
}