package com.example.spotify.screen.history

import androidx.lifecycle.viewModelScope
import com.example.spotify.AppBase
import com.example.spotify.domain.IViewEvent
import com.example.spotify.domain.base.BaseViewModel
import com.example.spotify.domain.viewstate.history.HistoryViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val application: AppBase
) : BaseViewModel<HistoryViewState, HistoryViewEvent>() {
    override fun createInitialState() = HistoryViewState()

    override fun onTriggerEvent(event: HistoryViewEvent) {
        viewModelScope.launch {

        }
    }
}

sealed class HistoryViewEvent : IViewEvent