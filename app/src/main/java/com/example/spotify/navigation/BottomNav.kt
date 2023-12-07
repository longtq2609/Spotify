package com.example.spotify.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.spotify.R
import com.example.spotify.screen.history.navigation.historyNavigationRoute
import com.example.spotify.screen.home.navigation.homeNavigationRoute
import com.example.spotify.screen.main.navigation.mainNavigationRoute
import com.example.spotify.screen.playlist.navigation.playListNavigationRoute
import com.example.spotify.screen.profile.navigation.profileNavigationRoute

enum class BottomNav(
    val id: Int,
    val route: String,
    @DrawableRes val iconId: Int,
    @StringRes val titleTextId: Int
) {
    HOME(
        0,
        homeNavigationRoute,
        R.drawable.ic_home,
        R.string.home_title_navigation
    ),
    PLAYLIST(
        1,
        playListNavigationRoute,
        R.drawable.ic_play_list,
        R.string.play_list_title_navigation
    ),
    MAIN(
        2,
        mainNavigationRoute,
        R.drawable.ic_logo_spotify,
        R.string.main_title_navigation
    ),
    HISTORY(
        3,
        historyNavigationRoute,
        R.drawable.ic_history,
        R.string.history_title_navigation
    ),
    PROFILE(
        4,
        profileNavigationRoute,
        R.drawable.ic_profile,
        R.string.profile_title_navigation
    )
}