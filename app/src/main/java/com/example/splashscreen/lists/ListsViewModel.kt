package com.example.splashscreen.lists

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.lists.ListsContract.Effect
import com.example.splashscreen.lists.ListsContract.Event
import com.example.splashscreen.lists.ListsContract.State
import com.example.splashscreen.main.BaseViewModel
import com.example.splashscreen.navigator.LinkNavigator
import com.example.splashscreen.navigator.ListDetailDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListsViewModel @Inject constructor(
    private val navigator: LinkNavigator,
) : BaseViewModel<Event, State, Effect>() {
    override fun provideInitialState() = State

    override fun handleEvent(event: Event) {
        when (event) {
            Event.OnActivityResumed -> viewModelScope.launch {
                delay(2000)
                Log.d("ListsViewModel", "OnActivityResumed")
                navigator.navigate(ListDetailDestination.route)
            }
            Event.OnButtonClicked -> navigator.navigate(ListDetailDestination.route)
        }
    }
}
