package com.easylife.noty.android.ui.screen.main

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.core.view.WindowCompat
import com.easylife.noty.android.ui.screen.main.theme.NotyTheme
import com.easylife.noty.core.navigation.NotyNavigator
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent

class MainActivity : ComponentActivity(), KoinComponent {

    private val viewModel: MainViewModel by viewModels()

    private val navigator: NotyNavigator by inject()

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
            val navHost = rememberAnimatedNavController()

            LaunchedEffect(Unit) {
                navigator.handleNavigationCommands(navHost)
            }

            NotyTheme {
                MainNoty(
                    navController = navHost,
                    navigator = navigator
                )
            }
        }
    }
}