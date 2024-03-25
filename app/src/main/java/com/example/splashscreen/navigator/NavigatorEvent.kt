package com.example.splashscreen.navigator

import androidx.navigation.NavOptionsBuilder

data class NavigatorEvent(val destination: String, val builder: NavOptionsBuilder.() -> Unit)
