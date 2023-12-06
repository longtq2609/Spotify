package com.example.spotify

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Stable
@Singleton
@HiltAndroidApp
class AppBase : Application() {
    val isDark = mutableStateOf(false)


    fun toogleTheme(){
        isDark.value = !isDark.value
    }
}

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun provideApplication(): AppBase = AppBase()
}