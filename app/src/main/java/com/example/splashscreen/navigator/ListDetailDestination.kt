package com.example.splashscreen.navigator

import android.net.Uri

object ListDetailDestination : NavigationDestination() {
    const val NAME: String = "listDetail"

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
