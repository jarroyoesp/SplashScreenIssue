package com.example.splashscreen.main

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splashscreen.component.*
import com.example.splashscreen.lists.ListsScreen
import com.example.splashscreen.main.MainContract.Event
import com.example.splashscreen.navigator.LinkNavigator
import com.example.splashscreen.navigator.NavigationDestination
import com.example.splashscreen.navigator.NavigatorEvent
import com.example.splashscreen.navigator.ListDestination
import com.example.splashscreen.theme.LinkTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var linkNavigator: LinkNavigator

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
        val splashScreen = installSplashScreen().apply { // must be called before super.onCreate()
            setKeepOnScreenCondition { true }  // must stay on until the compose LaunchEffect kicks in
        }
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            LinkTheme {
                LinkMainScreen(
                    startDestination = linkNavigator.homeDestination,
                    linkNavigator = linkNavigator,
                    splashScreen = splashScreen,
                )
            }
        }
        viewModel.onUiEvent(Event.OnIntentReceived(intent))
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        viewModel.onUiEvent(Event.OnIntentReceived(intent, true))
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialNavigationApi::class)
@Suppress("ReusedModifierInstance")
@Composable
fun LinkMainScreen(
    linkNavigator: LinkNavigator,
    startDestination: String,
    modifier: Modifier = Modifier,
    splashScreen: SplashScreen,
) {
    val navHostController = rememberNavController()
    val keyboardController = LocalSoftwareKeyboardController.current

    val splashScreenOnScreen = rememberSaveable { mutableStateOf(true) }
    LaunchedEffect(splashScreen) {
        splashScreen.setKeepOnScreenCondition { splashScreenOnScreen.value }
    }
    LaunchedEffect(navHostController) {
        linkNavigator.destinations.onEach { event ->
            keyboardController?.hide()
            when (event) {
                is NavigatorEvent.Directions -> navHostController.navigate(
                    event.destination,
                    event.builder,
                )

                is NavigatorEvent.HandleDeepLink -> navHostController.handleDeepLink(event.intent)
                is NavigatorEvent.NavigateUp -> navHostController.navigateUp()
                is NavigatorEvent.NavigateBack -> navHostController.popBackStack()
            }
        }.launchIn(this)
    }

    CompositionLocalProvider(
        LocalNavHostController provides navHostController,
        LocalSplashScreenOnScreen provides splashScreenOnScreen,

        ) {
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
}

fun NavGraphBuilder.addComposableDestinations() {
    mapOf<NavigationDestination, @Composable () -> Unit>(
        ListDestination to { ListsScreen() },
    )
        .forEach { entry ->
            val destination = entry.key
            composable(
                destination.route,
                destination.arguments,
                destination.deepLinks
            ) { entry.value() }
        }
}

