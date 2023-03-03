package com.easylife.noty.feature.note.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes
import com.easylife.noty.feature.note.NoteScreen
import com.google.accompanist.navigation.animation.composable
import org.koin.androidx.compose.getViewModel

/**
 * Created by erenalpaslan on 11.02.2023
 */
fun NotyNavigator.navigateToNoteScreen(note: String? = null) {
    this.navigate(NotyRoutes.noteRoute)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.noteScreen(navigator: NotyNavigator) {
    composable(route = NotyRoutes.noteRoute) {
        NoteScreen().Create(
            navigator = navigator,
            viewModel = getViewModel()
        )
    }
}