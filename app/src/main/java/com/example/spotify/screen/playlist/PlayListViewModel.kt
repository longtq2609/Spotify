package com.example.spotify.screen.playlist

import androidx.lifecycle.viewModelScope
import com.example.spotify.AppBase
import com.example.spotify.domain.IViewEvent
import com.example.spotify.domain.base.BaseViewModel
import com.example.spotify.domain.viewstate.playlist.PlayListViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayListViewModel @Inject constructor(
    private val application: AppBase
) : BaseViewModel<PlayListViewState, PlayListViewEvent>() {
    override fun createInitialState() = PlayListViewState()

    override fun onTriggerEvent(event: PlayListViewEvent) {
        viewModelScope.launch {
        }
    }
}

sealed class PlayListViewEvent : IViewEvent