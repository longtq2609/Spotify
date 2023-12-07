@file:OptIn(ExperimentalAnimationApi::class)

package com.example.spotify.screen.main.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.example.spotify.screen.main.MainScreen
import com.google.accompanist.navigation.animation.composable

const val mainNavigationRoute = "main_route"
fun NavController.navigationMain(
    navOptions: NavOptions? = null
) {
    this.navigate(mainNavigationRoute, navOptions)
}

fun NavGraphBuilder.mainScreen() {
    composable(mainNavigationRoute) {
        MainScreen(
        )
    }
}