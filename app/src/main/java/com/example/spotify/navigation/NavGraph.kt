package com.example.spotify.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.spotify.component.SpotifyBottomAppBar
import com.example.spotify.component.SpotifyScaffold
import com.example.spotify.screen.history.navigation.historyScreen
import com.example.spotify.screen.home.navigation.homeNavigationRoute
import com.example.spotify.screen.home.navigation.homeScreen
import com.example.spotify.screen.playlist.navigation.playListScreen
import com.example.spotify.screen.profile.navigation.profileScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph() {
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination = navController
        .currentBackStackEntryAsState().value?.destination
    SpotifyScaffold(
        bottomBar = {
            BottomNav.values().forEach { navItem ->
                if (navItem.route == currentRoute) {
                    SpotifyBottomAppBar(
                        navController = navController,
                        currentDestination = currentDestination
                    )
                }
            }
        },
        backgroundColor = MaterialTheme.colors.background
    ) { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = homeNavigationRoute,
            Modifier.padding(innerPadding)
        ) {
            homeScreen()
            playListScreen()
            historyScreen()
            profileScreen()
        }
    }
}