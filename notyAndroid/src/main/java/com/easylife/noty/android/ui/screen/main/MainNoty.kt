package com.easylife.noty.android.ui.screen.main

import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.easylife.noty.android.ui.navigation.NotyNavHost
import com.easylife.noty.android.ui.view.BottomNavRoutes
import com.easylife.noty.android.ui.view.BottomNavigation
import com.easylife.noty.android.ui.view.CategorySheetContent
import com.easylife.noty.android.ui.view.NotyFab
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.feature.note.navigation.navigateToNoteScreen
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 5.01.2023
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainNoty(
    navController: NavHostController,
    navigator: NotyNavigator
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        sheetContent = {
            CategorySheetContent {

            }
        },
        sheetPeekHeight = 0.dp,
        scaffoldState = bottomSheetScaffoldState,
        sheetBackgroundColor = Color.Transparent
    ) {
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
                            coroutineScope.launch {
                                bottomSheetScaffoldState.bottomSheetState.expand()
                            }
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
}