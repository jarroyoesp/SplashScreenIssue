package com.example.splashscreen.lists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun ListsScreen(viewModel: ListsViewModel = hiltViewModel()) {
    Column(modifier = Modifier.statusBarsPadding()) {
        Text("Lists screen")
    }
}

