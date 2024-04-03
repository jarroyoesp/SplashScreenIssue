package com.example.splashscreen.lists

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ListsViewModel @Inject constructor(
    private val pagingSourceFactory: ListsPagingSource.Factory,
) : ViewModel() {
    val items: Flow<PagingData<String>> = Pager(config = PagingConfig(pageSize = 20)) {
        pagingSourceFactory.create()
    }.flow
}
