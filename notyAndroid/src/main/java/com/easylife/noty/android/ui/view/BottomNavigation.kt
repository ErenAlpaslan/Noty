package com.easylife.noty.android.ui.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes

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
        icon = com.easylife.noty.core.designsystem.R.drawable.ic_house,
        selectedIcon = com.easylife.noty.core.designsystem.R.drawable.ic_fill_house,
        label = "Home",
        route = NotyRoutes.homeRoute
    ),
    PREMIUM(
        icon = com.easylife.noty.core.designsystem.R.drawable.ic_premium,
        selectedIcon = com.easylife.noty.core.designsystem.R.drawable.ic_fill_crown,
        label = "Premium",
        route = NotyRoutes.premiumRoute
    ),
    CATEGORIES(
        icon = com.easylife.noty.core.designsystem.R.drawable.ic_category,
        selectedIcon = com.easylife.noty.core.designsystem.R.drawable.ic_fill_category,
        label = "Categories",
        route = NotyRoutes.categoryRoute
    ),
    SETTINGS(
        icon = com.easylife.noty.core.designsystem.R.drawable.ic_settings,
        selectedIcon = com.easylife.noty.core.designsystem.R.drawable.ic_fill_settings,
        label = "Settings",
        route = NotyRoutes.settingsRoute
    )
}

@Composable
fun BottomNavigation(
    currentRoute: String?,
    navigator: NotyNavigator
) {
    val navigateToBottomTabs: (String) -> Unit = {
        navigator.navigate(it) {
            if (currentRoute != null) {
                popUpTo(currentRoute) {
                    inclusive = true
                }
            }
        }
    }

    if (currentRoute in BottomNavRoutes.routes) {
        Row(
            modifier = Modifier.fillMaxWidth().navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            BottomNavigationScreens.values().forEach { screen ->
                BottomNavigationItem(
                    selected = currentRoute == screen.route,
                    onClick = {
                        navigateToBottomTabs(screen.route)
                    },
                    label = screen.label,
                    icon = screen.icon,
                    selectedIcon = screen.selectedIcon
                )
            }

        }
    }
}

object BottomNavRoutes {
    val routes = listOf(
        NotyRoutes.homeRoute,
        NotyRoutes.premiumRoute,
        NotyRoutes.categoryRoute,
        NotyRoutes.settingsRoute
    )
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