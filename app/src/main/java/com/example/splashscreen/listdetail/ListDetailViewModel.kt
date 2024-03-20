package com.example.splashscreen.listdetail

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.listdetail.ListDetailContract
import com.example.splashscreen.listdetail.ListDetailContract.Effect
import com.example.splashscreen.listdetail.ListDetailContract.Event
import com.example.splashscreen.listdetail.ListDetailContract.State
import com.example.splashscreen.main.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListDetailViewModel @Inject constructor(
) : BaseViewModel<Event, State, Effect>() {
    init {
        Log.d("ListDetailViewModel", "Init")
        viewModelScope.launch {
            sendEffect { Effect.RemoveSplashScreen }
        }
    }

    override fun provideInitialState() = State

    override fun handleEvent(event: Event) {
    }
}
