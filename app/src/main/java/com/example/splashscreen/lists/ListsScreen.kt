package com.example.splashscreen.lists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.example.splashscreen.component.LocalSplashScreenOnScreen
import com.example.splashscreen.listdetail.ListDetailContract
import com.example.splashscreen.listdetail.ListDetailViewModel
import com.example.splashscreen.lists.ListsContract.Effect
import com.example.splashscreen.lists.ListsContract.Event
import com.example.splashscreen.lists.ListsContract.State
import com.example.splashscreen.theme.Spacing
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach


@Composable
fun ListsScreen(viewModel: ListsViewModel = hiltViewModel()) {
    ListsScreen(
        state = viewModel.viewState.value,
        sendEvent = { viewModel.onUiEvent(it) },
        effectFlow = viewModel.effect,
    )
}

@Composable
fun ListsScreen(
    state: State,
    sendEvent: (event: Event) -> Unit,
    effectFlow: Flow<Effect>,
    viewModel: ListDetailViewModel = hiltViewModel(),
) {
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        sendEvent(Event.OnActivityResumed)
    }
    Column(modifier = Modifier.statusBarsPadding()) {
        Button(onClick = { }) {
            Text("Add New")
        }
    }
}
