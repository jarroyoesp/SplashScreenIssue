package com.example.splashscreen.component

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

val LocalNavHostController: ProvidableCompositionLocal<NavHostController> =
    compositionLocalOf { error("No NavHostController provided") }

val LocalSplashScreenOnScreen: ProvidableCompositionLocal<MutableState<Boolean>> = compositionLocalOf { error("No SplashScreenOnScreen provided") }
