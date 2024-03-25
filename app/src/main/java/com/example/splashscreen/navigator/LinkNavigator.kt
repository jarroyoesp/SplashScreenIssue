package com.example.splashscreen.navigator

import android.content.Intent
import androidx.navigation.NavOptionsBuilder
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@ActivityRetainedScoped
class LinkNavigator @Inject constructor() {
    private val navigationEvents = Channel<NavigatorEvent>(capacity = Channel.CONFLATED)
    val destinations = navigationEvents.receiveAsFlow()
    val homeDestination = ListDestination.get()


    fun navigate(
        route: String,
        builder: NavOptionsBuilder.() -> Unit = { launchSingleTop = true }
    ): Boolean =
        navigationEvents.trySend(NavigatorEvent(route, builder)).isSuccess
}
