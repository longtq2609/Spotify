package com.example.spotify.screen.profile

import androidx.lifecycle.viewModelScope
import com.example.spotify.AppBase
import com.example.spotify.domain.IViewEvent
import com.example.spotify.domain.base.BaseViewModel
import com.example.spotify.domain.viewstate.profile.ProfileViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val application: AppBase
) : BaseViewModel<ProfileViewState, ProfileViewEvent>() {
    override fun createInitialState() = ProfileViewState()

    override fun onTriggerEvent(event: ProfileViewEvent) {
        viewModelScope.launch { }
    }
}

sealed class ProfileViewEvent : IViewEvent