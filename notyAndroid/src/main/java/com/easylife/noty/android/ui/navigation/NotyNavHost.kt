package com.easylife.noty.android.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.easylife.feature.premium.navigation.premiumScreen
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes.splashRoute
import com.easylife.noty.feature.home.navigation.homeScreen
import com.easylife.noty.feature.note.navigation.noteScreen
import com.easylife.noty.feature.settings.navigation.settingsScreen
import com.easylife.noty.feature.splash.navigation.splashScreen
import com.easylife.noty.feature_category.navigation.categoryScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NotyNavHost(
    navigator: NotyNavigator,
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = splashRoute,
        modifier = Modifier.padding(
            bottom = paddingValues.calculateBottomPadding()
        )
    ) {
        splashScreen(navigator)
        homeScreen(navigator)
        premiumScreen(navigator)
        categoryScreen(navigator)
        settingsScreen(navigator)
        noteScreen(navigator)
    }
}