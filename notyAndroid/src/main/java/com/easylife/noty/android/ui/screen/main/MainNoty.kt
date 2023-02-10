package com.easylife.noty.android.ui.screen.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.easylife.noty.android.ui.navigation.NotyNavHost
import com.easylife.noty.core.navigation.NotyNavigator

/**
 * Created by erenalpaslan on 5.01.2023
 */
@Composable
fun MainNoty(
    navController: NavHostController,
    navigator: NotyNavigator
) {
    Scaffold() {
        NotyNavHost(
            navigator = navigator,
            navController = navController,
            paddingValues = it
        )
    }
}