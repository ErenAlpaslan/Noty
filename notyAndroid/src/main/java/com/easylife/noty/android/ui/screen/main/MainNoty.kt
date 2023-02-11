package com.easylife.noty.android.ui.screen.main

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.easylife.noty.android.ui.navigation.NotyNavHost
import com.easylife.noty.android.ui.view.BottomNavRoutes
import com.easylife.noty.android.ui.view.BottomNavigation
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.android.ui.view.NotyFab
import com.easylife.noty.feature.note.navigation.navigateToNoteScreen

/**
 * Created by erenalpaslan on 5.01.2023
 */
@Composable
fun MainNoty(
    navController: NavHostController,
    navigator: NotyNavigator
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            BottomNavigation(
                currentRoute = currentDestination?.route,
                navigator = navigator
            )
        },
        floatingActionButton = {
            if (currentDestination?.route in BottomNavRoutes.routes) {
                NotyFab(
                    onAddNoteClicked = {
                        navigator.navigateToNoteScreen()
                    },
                    onAddCategoryClicked = {

                    }
                )
            }
        }
    ) {
        NotyNavHost(
            navigator = navigator,
            navController = navController,
            paddingValues = it
        )
    }
}