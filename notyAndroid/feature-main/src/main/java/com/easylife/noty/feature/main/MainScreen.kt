package com.easylife.noty.feature.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.easylife.noty.core.designsystem.base.BaseScreen
import com.easylife.noty.feature.main.navigation.MainNavHost
import com.easylife.noty.feature.main.view.BottomNavigation
import com.easylife.noty.feature.main.view.NotyFab
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

/**
 * Created by erenalpaslan on 10.02.2023
 */
class MainScreen : BaseScreen<MainViewModel>() {

    @Composable
    override fun Screen() {
        Content()
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun Content() {
        val navController = rememberAnimatedNavController()

        Scaffold(
            bottomBar = {
                BottomNavigation(navController = navController)
            },
            floatingActionButton = {
                NotyFab(
                    onAddNoteClicked = {

                    },
                    onAddCategoryClicked = {

                    }
                )
            },
        ) { paddingValues ->
            MainNavHost(
                navigator = navigator,
                navController = navController,
                paddingValues = paddingValues
            )
        }
    }

}
