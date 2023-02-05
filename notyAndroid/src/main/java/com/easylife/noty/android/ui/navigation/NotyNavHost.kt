package com.easylife.noty.android.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes.splashRoute
import com.easylife.noty.feature.splash.navigation.splashScreen
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
        /*themeScreen(navigator)
        noteScreen(navigator)
        diaryScreen(navigator)
        calendarScreen(navigator)
        insightsScreen(navigator)
        settingsScreen(navigator)*/
    }
}