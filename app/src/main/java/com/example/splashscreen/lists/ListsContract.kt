package com.example.splashscreen.lists

import androidx.compose.runtime.Immutable
import com.example.splashscreen.main.ViewEffect
import com.example.splashscreen.main.ViewEvent
import com.example.splashscreen.main.ViewState

@Immutable
object ListsContract {
    object State : ViewState

    sealed class Event : ViewEvent

    sealed class Effect : ViewEffect {
        object RemoveSplashScreen : Effect()
    }
}
