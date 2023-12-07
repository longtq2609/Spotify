@file:OptIn(ExperimentalAnimationApi::class)

package com.example.spotify.screen.playlist.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.example.spotify.screen.playlist.PlayListScreen
import com.google.accompanist.navigation.animation.composable

const val playListNavigationRoute = "play_list_route"

fun NavController.navigationPlayList(
    navOptions: NavOptions? = null
){
    this.navigate(playListNavigationRoute, navOptions)
}

fun NavGraphBuilder.playListScreen() {
    composable(playListNavigationRoute) {
        PlayListScreen(
            hiltViewModel()
        )
    }
}