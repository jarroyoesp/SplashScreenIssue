package com.example.splashscreen.component

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf

val LocalSplashScreenOnScreen: ProvidableCompositionLocal<MutableState<Boolean>> = compositionLocalOf { error("No SplashScreenOnScreen provided") }
