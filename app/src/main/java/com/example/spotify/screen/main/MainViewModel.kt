package com.example.spotify.screen.main

import androidx.lifecycle.viewModelScope
import com.example.spotify.AppBase
import com.example.spotify.domain.IViewEvent
import com.example.spotify.domain.base.BaseViewModel
import com.example.spotify.domain.viewstate.main.MainViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val application: AppBase
) : BaseViewModel<MainViewState, MainViewEvent>() {

    override fun createInitialState() = MainViewState()

    override fun onTriggerEvent(event: MainViewEvent) {
        viewModelScope.launch {
        }
    }
}

sealed class MainViewEvent : IViewEvent