package com.example.splashscreen.listdetail

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.splashscreen.component.LocalSplashScreenOnScreen
import com.example.splashscreen.listdetail.ListDetailContract.Effect
import com.example.splashscreen.listdetail.ListDetailContract.Event
import com.example.splashscreen.listdetail.ListDetailContract.State
import com.example.splashscreen.theme.Spacing
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach


@Composable
fun ListDetailScreen(viewModel: ListDetailViewModel = hiltViewModel()) {
    Log.d("ListDetailScreen", "Create")
    ListDetailScreen(
        state = viewModel.viewState.value,
        sendEvent = { viewModel.onUiEvent(it) },
        effectFlow = viewModel.effect,
    )
}

@Composable
fun ListDetailScreen(
    state: State,
    sendEvent: (event: Event) -> Unit,
    effectFlow: Flow<Effect>,
    viewModel: ListDetailViewModel = hiltViewModel(),
) {
    Log.d("ListDetailScreen", "Create UI")
    val splashScreenOnScreen = LocalSplashScreenOnScreen.current
    LaunchedEffect(effectFlow) {
        effectFlow.onEach { effect ->
            when (effect) {
                is Effect.RemoveSplashScreen -> splashScreenOnScreen.value = false
            }
        }.collect()
    }
    Column(modifier = Modifier.statusBarsPadding()) {
        Text("Screen Detail")
        Button(onClick = { }) {
            Text("Detail")
        }
    }
}
