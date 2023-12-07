package com.example.spotify.component

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.example.spotify.navigation.BottomNav
import com.example.spotify.screen.history.navigation.navigationHistory
import com.example.spotify.screen.home.navigation.navigationHome
import com.example.spotify.screen.main.navigation.mainNavigationRoute
import com.example.spotify.screen.main.navigation.navigationMain
import com.example.spotify.screen.playlist.navigation.navigationPlayList
import com.example.spotify.screen.profile.navigation.navigationProfile
import com.example.spotify.ui.theme.Black
import com.example.spotify.ui.theme.Grey
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@Composable
fun SpotifyBottomAppBar(
    navController: NavController,
    currentDestination: NavDestination?
) {
    BottomAppBar(
        modifier = Modifier,
        backgroundColor = Grey
    ) {
        BottomNav.values().forEach { screen ->
            val selected = currentDestination.isBottomNavDestinationInHierarchy(screen)
            val primaryColor = MaterialTheme.colors.primary
            val secondaryColor = MaterialTheme.colors.secondary
            val showLabel = screen.id != 2
            BottomNavigationItem(
                modifier = Modifier,
                alwaysShowLabel = showLabel,
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Black,
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = screen.iconId),
                        contentDescription = null,
                        tint = if (selected) primaryColor else secondaryColor,
                        modifier = Modifier.size(32.dp)
                    )
                },

                label = {
                    SpotifyText(
                        text =  stringResource(
                            id = screen.titleTextId
                        ),
                        color = if (selected) primaryColor else secondaryColor,
                        style = MaterialTheme.typography.overline,
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                },
                selected = selected,
                onClick = {
                    navigateToBottomNavDestination(screen, navController)
                }
            )
        }
    }
}

fun navigateToBottomNavDestination(bottomNav: BottomNav, navController: NavController) {
    trace("Navigation: ${bottomNav.name}") {
        Log.e("longtq", "navigateToBottomNavDestination: ${bottomNav.name}")
        val bottomNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (bottomNav) {
            BottomNav.HOME -> navController.navigationHome(bottomNavOptions)
            BottomNav.PLAYLIST -> navController.navigationPlayList(bottomNavOptions)
            BottomNav.MAIN -> navController.navigationMain(bottomNavOptions)
            BottomNav.HISTORY -> navController.navigationHistory(bottomNavOptions)
            BottomNav.PROFILE -> navController.navigationProfile(bottomNavOptions)
        }
    }
}

private fun NavDestination?.isBottomNavDestinationInHierarchy(destination: BottomNav) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberAnimatedNavController()
    SpotifyBottomAppBar(
        navController = navController, currentDestination = NavDestination(
            mainNavigationRoute
        )
    )
}