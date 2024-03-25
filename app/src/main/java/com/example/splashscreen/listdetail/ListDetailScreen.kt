package com.example.splashscreen.listdetail

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun ListDetailScreen(viewModel: ListDetailViewModel = hiltViewModel()) {
    Log.d("ListDetailScreen", "Create")
    Column(modifier = Modifier.statusBarsPadding()) {
        Text("List Detail screen")
    }
}

