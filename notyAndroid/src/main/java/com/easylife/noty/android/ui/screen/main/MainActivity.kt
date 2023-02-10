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
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    internal lateinit var navigator: NotyNavigator

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