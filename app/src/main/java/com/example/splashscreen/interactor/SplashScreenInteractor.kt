package com.example.splashscreen.interactor

import androidx.core.splashscreen.SplashScreen

interface SplashScreenInteractor {
    val currentlyShowing: Boolean
    fun initialize(splashScreen: SplashScreen)
    fun requestToHide(force: Boolean = false)
    fun show()
}
