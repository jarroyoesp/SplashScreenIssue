package com.example.splashscreen.lists

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems


@Composable
fun ListsScreen(viewModel: ListsViewModel = hiltViewModel()) {
    val lazyPagingItems = viewModel.items.collectAsLazyPagingItems()
    LazyColumn(modifier = Modifier.statusBarsPadding()) {
        item {
            Text("List screen")
        }
        items(count = lazyPagingItems.itemCount) { index ->
            val item = lazyPagingItems[index]
            Text(text = "List $item")
        }
    }
}

