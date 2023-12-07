@file:OptIn(ExperimentalAnimationApi::class)

package com.example.spotify.screen.profile.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.example.spotify.screen.profile.ProfileScreen
import com.google.accompanist.navigation.animation.composable

const val profileNavigationRoute = "profile_route"

fun NavController.navigationProfile(
    navOptions: NavOptions? = null
){
    this.navigate(profileNavigationRoute, navOptions)
}

fun NavGraphBuilder.profileScreen() {
    composable(profileNavigationRoute) {
        ProfileScreen(
            hiltViewModel()
        )
    }
}