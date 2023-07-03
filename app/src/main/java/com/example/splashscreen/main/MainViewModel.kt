package com.example.splashscreen.main

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.main.MainContract.Effect
import com.example.splashscreen.main.MainContract.Event
import com.example.splashscreen.main.MainContract.State
import com.example.splashscreen.navigator.LinkNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val linkNavigator: LinkNavigator,
) : BaseViewModel<Event, State, Effect>(), DefaultLifecycleObserver {

    override fun provideInitialState() = State(linkNavigator.homeDestination)

    override fun handleEvent(event: Event) {
        when (event) {
            is Event.OnIntentReceived -> handleOnIntentReceived(event)
        }
    }

    private fun handleOnIntentReceived(event: Event.OnIntentReceived) {
        viewModelScope.launch {
            if (event.isNewIntent) {
                linkNavigator.handleDeepLink(event.intent)
            }
        }
    }

}
