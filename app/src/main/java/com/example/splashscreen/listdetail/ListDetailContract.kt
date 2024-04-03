package com.example.splashscreen.listdetail

import androidx.compose.runtime.Immutable
import com.example.splashscreen.base.ViewEffect
import com.example.splashscreen.base.ViewEvent
import com.example.splashscreen.base.ViewState

@Immutable
object ListDetailContract {
    data class State(
        val flowData: FlowPagingDataString? = null
    ) : ViewState

    sealed class Event : ViewEvent

    sealed class Effect : ViewEffect
}
