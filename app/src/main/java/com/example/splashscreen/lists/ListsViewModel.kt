package com.example.splashscreen.lists

import androidx.lifecycle.viewModelScope
import com.example.splashscreen.lists.ListsContract.Effect
import com.example.splashscreen.main.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListsViewModel @Inject constructor(
) : BaseViewModel<ListsContract.Event, ListsContract.State, Effect>() {
    init {
        viewModelScope.launch {
            //delay(TimeUnit.SECONDS.toMillis(1))
            sendEffect { Effect.RemoveSplashScreen }
        }
    }

    override fun provideInitialState() = ListsContract.State

    override fun handleEvent(event: ListsContract.Event) {
    }
}
