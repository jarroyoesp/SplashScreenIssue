package com.example.splashscreen.interactor

import androidx.core.splashscreen.SplashScreen
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject


@ActivityRetainedScoped
class SplashScreenInteractor @Inject constructor() {
    private var currentlyShowing: Boolean = true
    private var splashScreen: SplashScreen? = null

    fun initialize(splashScreen: SplashScreen) {
        this.splashScreen = splashScreen
        splashScreen.setKeepOnScreenCondition { currentlyShowing }
    }

    fun hide() {
        checkNotNull(splashScreen) { "SplashScreen not initialized!" }
        currentlyShowing = false
    }
}
