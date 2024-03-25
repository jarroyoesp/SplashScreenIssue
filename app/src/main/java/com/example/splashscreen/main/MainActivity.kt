package com.example.splashscreen.main

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.interactor.SplashScreenInteractor
import com.example.splashscreen.listdetail.ListDetailScreen
import com.example.splashscreen.lists.ListsScreen
import com.example.splashscreen.navigator.LinkNavigator
import com.example.splashscreen.navigator.ListDestination
import com.example.splashscreen.navigator.ListDetailDestination
import com.example.splashscreen.navigator.NavigationDestination
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var linkNavigator: LinkNavigator

    @Inject
    lateinit var splashScreenInteractor: SplashScreenInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
        val splashScreen = installSplashScreen()  // must be called before super.onCreate()
        super.onCreate(savedInstanceState)
        splashScreenInteractor.initialize(splashScreen)  // must be called after super.onCreate()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MaterialTheme {
                MainScreen(
                    startDestination = linkNavigator.homeDestination,
                    linkNavigator = linkNavigator,
                )
            }
        }
    }
}

@Suppress("ReusedModifierInstance")
@Composable
fun MainScreen(
    linkNavigator: LinkNavigator,
    startDestination: String,
) {
    val navHostController = rememberNavController()

    LaunchedEffect(navHostController) {
        linkNavigator.destinations.onEach { event ->
            Log.d("MainActivity", "Navigate to ${event.destination}")
            navHostController.navigate(
                event.destination,
                event.builder,
            )
        }.launchIn(this)
    }

    Box {
        NavHost(
            navController = navHostController,
            startDestination = startDestination,
            modifier = Modifier.padding(16.dp),
            builder = {
                addComposableDestinations()
            },
        )
    }
}

fun NavGraphBuilder.addComposableDestinations() {
    mapOf<NavigationDestination, @Composable () -> Unit>(
        ListDestination to { ListsScreen() },
        ListDetailDestination to { ListDetailScreen() },
    )
        .forEach { entry ->
            val destination = entry.key
            composable(destination.route) { entry.value() }
        }
}

