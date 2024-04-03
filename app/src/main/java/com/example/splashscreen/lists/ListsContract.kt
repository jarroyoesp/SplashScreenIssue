package com.example.splashscreen.lists

import androidx.compose.runtime.Immutable
import com.example.splashscreen.base.ViewEffect
import com.example.splashscreen.base.ViewEvent
import com.example.splashscreen.base.ViewState

@Immutable
object ListsContract {
    data class State(
        val text: String = "text"
    ) : ViewState

    sealed class Event : ViewEvent

    sealed class Effect : ViewEffect
}
