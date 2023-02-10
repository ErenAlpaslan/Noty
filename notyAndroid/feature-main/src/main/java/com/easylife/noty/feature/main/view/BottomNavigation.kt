package com.easylife.noty.feature.main.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes
import com.easylife.noty.feature.main.R

/**
 * Created by erenalpaslan on 10.02.2023
 */
enum class BottomNavigationScreens(
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int,
    val label: String,
    val route: String
) {
    HOME(
        icon = R.drawable.ic_house,
        selectedIcon = R.drawable.ic_fill_house,
        label = "Home",
        route = NotyRoutes.homeRoute
    ),
    PREMIUM(
        icon = R.drawable.ic_premium,
        selectedIcon = R.drawable.ic_fill_crown,
        label = "Premium",
        route = NotyRoutes.premiumRoute
    ),
    CATEGORIES(
        icon = R.drawable.ic_category,
        selectedIcon = R.drawable.ic_fill_category,
        label = "Categories",
        route = NotyRoutes.categoryRoute
    ),
    SETTINGS(
        icon = R.drawable.ic_settings,
        selectedIcon = R.drawable.ic_fill_settings,
        label = "Settings",
        route = NotyRoutes.settingsRoute
    )
}

@Composable
fun BottomNavigation(
    navController: NavHostController
) {
    var currentRoute by remember {
        mutableStateOf(NotyRoutes.homeRoute)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val navigateToBottomTabs: (String) -> Unit = {
        navController.navigate(it) {
            popUpTo(currentRoute) {
                inclusive = true
            }
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomNavigationScreens.values().forEach {screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navigateToBottomTabs(screen.route)
                    currentRoute = screen.route
                },
                label = screen.label,
                icon = screen.icon,
                selectedIcon = screen.selectedIcon
            )
        }
    }
}

@Composable
fun BottomNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    label: String,
    @DrawableRes icon: Int,
    @DrawableRes selectedIcon: Int,
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(
            painter = painterResource(id = if (selected) selectedIcon else icon),
            contentDescription = label
        )
    }
}