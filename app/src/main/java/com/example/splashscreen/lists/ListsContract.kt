package com.example.splashscreen.lists

import androidx.compose.runtime.Immutable
import com.example.splashscreen.listdetail.ListDetailContract
import com.example.splashscreen.main.ViewEffect
import com.example.splashscreen.main.ViewEvent
import com.example.splashscreen.main.ViewState

@Immutable
object ListsContract {
    object State : ViewState

    sealed class Event : ViewEvent {
        data object OnActivityResumed : Event()
        data object OnButtonClicked: Event()
    }

    sealed class Effect : ViewEffect
}
