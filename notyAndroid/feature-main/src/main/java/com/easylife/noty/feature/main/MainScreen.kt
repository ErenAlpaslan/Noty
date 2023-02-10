package com.easylife.noty.feature.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.easylife.noty.core.designsystem.base.BaseScreen
import com.easylife.noty.feature.main.navigation.MainNavHost
import com.easylife.noty.feature.main.view.BottomNavigation
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
            }
        ) { paddingValues ->
            MainNavHost(
                navigator = navigator,
                navController = navController,
                paddingValues = paddingValues
            )
        }
    }

}
