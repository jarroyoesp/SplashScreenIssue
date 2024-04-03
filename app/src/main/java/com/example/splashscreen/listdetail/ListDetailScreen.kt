package com.example.splashscreen.listdetail

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems


@Composable
fun ListDetailScreen(viewModel: ListDetailViewModel = hiltViewModel()) {
    Log.d("ListDetailScreen", "Create")
    val lazyPagingItems = viewModel.items.collectAsLazyPagingItems()
    LazyColumn(modifier = Modifier.statusBarsPadding()) {
        item {
            Text("ListDetailScreen")
        }
        items(count = lazyPagingItems.itemCount) { index ->
            val item = lazyPagingItems[index]
            Text(text = "List $item")
        }
    }
}
