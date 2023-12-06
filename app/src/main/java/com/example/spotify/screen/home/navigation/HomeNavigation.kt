@file:OptIn(ExperimentalAnimationApi::class)

package com.example.spotify.screen.home.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.example.spotify.screen.home.HomeScreen
import com.google.accompanist.navigation.animation.composable

const val homeNavigationRoute = "home_route"

fun NavController.navigationHome(
    navOptions: NavOptions? = null
) {
    this.navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen() {
    composable(homeNavigationRoute) {
        HomeScreen(
        )
    }
}
