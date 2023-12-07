@file:OptIn(ExperimentalAnimationApi::class, ExperimentalAnimationApi::class)

package com.example.spotify.screen.history.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.example.spotify.screen.history.HistoryScreen
import com.google.accompanist.navigation.animation.composable


const val historyNavigationRoute = "history_route"

fun NavController.navigationHistory(
    navOptions: NavOptions? = null
){
    this.navigate(historyNavigationRoute, navOptions)
}

fun NavGraphBuilder.historyScreen() {
    composable(historyNavigationRoute) {
        HistoryScreen(
            hiltViewModel()
        )
    }
}

