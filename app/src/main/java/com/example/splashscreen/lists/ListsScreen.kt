package com.example.splashscreen.lists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.splashscreen.component.LocalSplashScreenOnScreen
import com.example.splashscreen.listdetail.ListDetailViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach


@Composable
fun ListsScreen(viewModel: ListsViewModel = hiltViewModel()) {
    Column(modifier = Modifier.statusBarsPadding()) {
        Button(onClick = { }) {
            Text("List screen")
        }
    }
}
