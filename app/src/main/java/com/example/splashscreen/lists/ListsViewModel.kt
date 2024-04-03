package com.example.splashscreen.lists

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
            delay(2000)
            navigator.navigate(ListDetailDestination.route)
        }
    }
}
