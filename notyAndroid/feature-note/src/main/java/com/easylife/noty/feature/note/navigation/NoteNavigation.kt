package com.easylife.noty.feature.note.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes
import com.easylife.noty.data.entity.NoteUI
import com.easylife.noty.feature.note.NoteScreen
import com.google.accompanist.navigation.animation.composable
import org.koin.androidx.compose.getViewModel

/**
 * Created by erenalpaslan on 11.02.2023
 */
fun NotyNavigator.navigateToNoteScreen(note: NoteUI?) {
    if (note != null) {
        this.navigate(NotyRoutes.noteRoute+"?noteId=${note.id}")
    }else {
        this.navigate(NotyRoutes.noteRoute)
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.noteScreen(navigator: NotyNavigator) {
    composable(
        route = NotyRoutes.noteRoute+"?noteId={noteId}",
        arguments = listOf(navArgument("noteId") {
            this.type = NavType.StringType
            this.nullable = true
            this.defaultValue = null
        })
    ) {
        NoteScreen().Create(
            navigator = navigator,
            viewModel = getViewModel()
        )
    }
}