package com.example.splashscreen.interactor

import androidx.core.splashscreen.SplashScreen
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject


@ActivityRetainedScoped
internal class SplashScreenInteractorImpl @Inject constructor(): SplashScreenInteractor {
    // Normally this would be an AtomicInteger() but I'm afraid of performance issues when used with setKeepOnScreenCondition {}
    private var invocationCount = 0
    override val currentlyShowing: Boolean
        get() = invocationCount > 0
    private var splashScreen: SplashScreen? = null

    override fun initialize(splashScreen: SplashScreen) {
        this.splashScreen = splashScreen
        show()
        splashScreen.setKeepOnScreenCondition { currentlyShowing }
    }

    /**
     * Request to hide the Splash Screen. The Splash Screen will be hidden only once the number of invocation of [requestToHide] matches or outnumber
     * the one of [show]
     *
     * @param force hides the Splash Screen immediately resetting the invocation count
     */
    override fun requestToHide(force: Boolean) {
        checkNotNull(splashScreen) { "SplashScreen not initialized!" }
        if (currentlyShowing) {
            if (force) {
                invocationCount = 0
            } else {
                invocationCount--
            }
        }
        // Sanity check
        check(invocationCount >= 0) { "runningJobs is negative! Probably a concurrency issue? Try switching to AtomicInteger()" }
    }

    override fun show() {
        checkNotNull(splashScreen) { "SplashScreen not initialized!" }
        invocationCount++
    }
}
