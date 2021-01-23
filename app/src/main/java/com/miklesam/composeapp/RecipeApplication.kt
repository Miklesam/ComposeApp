package com.miklesam.composeapp

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RecipeApplication : Application() {

    val isDark = mutableStateOf(false)

    fun toggleLightTheme() {
        isDark.value = !isDark.value
    }

}