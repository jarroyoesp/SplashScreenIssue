package com.example.splashscreen.listdetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.splashscreen.interactor.SplashScreenInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListDetailViewModel @Inject constructor(
    splashScreenInteractor: SplashScreenInteractor,
) : ViewModel() {
    init {
        Log.d("ListDetailViewModel", "Init")
        viewModelScope.launch {
            delay(500)
            splashScreenInteractor.hide()
        }
    }
}
