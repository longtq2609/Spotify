package com.example.spotify.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.spotify.R
import com.example.spotify.component.SpotifyScaffold
import com.example.spotify.component.SpotifyText
import com.example.spotify.component.SpotifyTopBar
import com.example.spotify.screen.main.MainScreen
import com.example.spotify.ui.theme.Black


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val viewState by viewModel.uiState.collectAsState()

    SpotifyScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        backgroundColor = Black,
        topBar = {
            SpotifyTopBar(
                text = stringResource(id = R.string.home_title_navigation),
                actionIcon = R.drawable.ic_setting,
                backgroundColor = Black,
                isShowLogo = true
            )
        },
        content = {
            Content()
        }
    )
}

@Composable
private fun Content(

) {
    Box(modifier = Modifier.fillMaxSize()) {
        SpotifyText(text = stringResource(id = R.string.home_title_navigation))
    }
}

@Preview(showBackground = true)
@Composable
private fun MainPreview() {
    MainScreen()
}