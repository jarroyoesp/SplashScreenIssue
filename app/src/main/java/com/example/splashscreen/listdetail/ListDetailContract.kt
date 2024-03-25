package com.example.splashscreen.listdetail

import androidx.compose.runtime.Immutable
import com.example.splashscreen.main.ViewEffect
import com.example.splashscreen.main.ViewEvent
import com.example.splashscreen.main.ViewState

@Immutable
object ListDetailContract {
    object State : ViewState

    sealed class Event : ViewEvent {
        data object OnActivityResumed : Event()
    }

    sealed class Effect : ViewEffect
}
