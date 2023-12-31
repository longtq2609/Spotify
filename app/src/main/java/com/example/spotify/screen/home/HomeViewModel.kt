package com.example.spotify.screen.home

import androidx.lifecycle.viewModelScope
import com.example.spotify.AppBase
import com.example.spotify.domain.IViewEvent
import com.example.spotify.domain.base.BaseViewModel
import com.example.spotify.domain.viewstate.home.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val application: AppBase
) : BaseViewModel<HomeViewState, HomeViewEvent>() {
    override fun createInitialState() = HomeViewState()
    override fun onTriggerEvent(event: HomeViewEvent) {
        viewModelScope.launch {
        }
    }
}

sealed class HomeViewEvent : IViewEvent