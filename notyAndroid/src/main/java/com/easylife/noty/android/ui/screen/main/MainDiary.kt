package com.easylife.noty.android.ui.screen.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.easylife.noty.android.ui.navigation.NotyNavHost
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes

/**
 * Created by erenalpaslan on 5.01.2023
 */
@Composable
fun MainNoty(
    navController: NavHostController,
    navigator: NotyNavigator
) {
    var currentRoute by remember {
        mutableStateOf(NotyRoutes.diaryRoute)
    }

    val navigateToBottomTabs: (String) -> Unit = {
        navController.navigate(it) {
            popUpTo(currentRoute) {
                inclusive = true
            }
        }
    }

    Scaffold() {
        NotyNavHost(
            navigator = navigator,
            navController = navController,
            paddingValues = it
        )
    }
}

private val bottomNavVisible = listOf(
    NotyRoutes.diaryRoute,
    NotyRoutes.calendarRoute,
    NotyRoutes.insightsRoute,
    NotyRoutes.settingsRoute
)