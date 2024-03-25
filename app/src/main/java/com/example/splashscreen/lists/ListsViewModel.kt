package com.example.splashscreen.lists

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.navigator.LinkNavigator
import com.example.splashscreen.navigator.ListDetailDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListsViewModel @Inject constructor(
    private val navigator: LinkNavigator,
) : ViewModel() {
    init {
        viewModelScope.launch {
            delay(500)
            Log.d("ListsViewModel", "OnActivityResumed")
            navigator.navigate(ListDetailDestination.route)
        }
    }
}
