package com.example.splashscreen.lists

import androidx.lifecycle.viewModelScope
import com.example.splashscreen.lists.ListsContract.Effect
import com.example.splashscreen.lists.ListsContract.Event
import com.example.splashscreen.lists.ListsContract.State
import com.example.splashscreen.main.BaseViewModel
import com.example.splashscreen.navigator.LinkNavigator
import com.example.splashscreen.navigator.LinkNavigatorImpl
import com.example.splashscreen.navigator.ListDetailDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListsViewModel @Inject constructor(
    private val navigator: LinkNavigator,
) : BaseViewModel<Event, State, Effect>() {
    init {
        viewModelScope.launch {
            delay(2000)
            navigator.navigate(ListDetailDestination.route)
        }
    }

    override fun provideInitialState() = State

    override fun handleEvent(event: Event) {
        when(event) {
            Event.OnButtonClicked -> navigator.navigate(ListDetailDestination.route)
        }
    }
}
