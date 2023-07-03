package com.example.splashscreen.navigator

import android.net.Uri

object ListDestination : NavigationDestination() {
    const val NAME: String = "list"

    override val route: String = Uri.Builder()
        .appendPath(NAME)
        .build()
        .toString()
        .removePrefix("/")


    fun `get`(): String = Uri.Builder().apply {
        appendPath(NAME)
    }
        .build()
        .toString()
        .removePrefix("/")

}
