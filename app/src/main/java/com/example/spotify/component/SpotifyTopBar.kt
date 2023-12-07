package com.example.spotify.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.spotify.R
import com.example.spotify.ui.theme.Black

@Composable
fun SpotifyTopBar(
    modifier: Modifier = Modifier,
    text: String,
    navigationIcon: (() -> Unit)? = {},
    actions: (() -> Unit)? = {},
    actionIcon: Int,
    isShowLogo: Boolean,
    backgroundColor: Color,
    contentColor: Color = MaterialTheme.colors.background,
    elevation: Dp = 0.dp
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        title = {
            if (isShowLogo) {
                Image(
                    painterResource(R.drawable.ic_logo),
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth().height(35.dp)
                )
            } else {
                SpotifyText(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = text
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                if (navigationIcon != null) {
                    navigationIcon()
                }
            }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
                    contentDescription = ""
                )
            }
        },
        actions = {
            IconButton(onClick = {
                if (actions != null) {
                    actions()
                }
            }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = actionIcon),
                    contentDescription = ""
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun AppBarPreview() {
    SpotifyTopBar(
        text = "Home",
        actionIcon = R.drawable.ic_setting,
        backgroundColor = Black,
        isShowLogo = true
    )
}