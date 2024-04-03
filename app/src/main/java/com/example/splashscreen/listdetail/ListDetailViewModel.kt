package com.example.splashscreen.listdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.splashscreen.base.BaseViewModel
import com.example.splashscreen.listdetail.ListDetailContract.Effect
import com.example.splashscreen.listdetail.ListDetailContract.Event
import com.example.splashscreen.listdetail.ListDetailContract.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ListDetailViewModel @Inject constructor(
    private val pagingSourceFactory: ListDetailPagingSource.Factory,
) : BaseViewModel<Event, State, Effect>() {
    override fun provideInitialState(): State = State(flowData = getData())

    override fun handleEvent(event: Event) {}

    private fun getData(): FlowPagingDataString = Pager(
        PagingConfig(
            pageSize = ListDetailPagingSource.PAGE_SIZE,
            prefetchDistance = ListDetailPagingSource.PAGE_SIZE,
            initialLoadSize = ListDetailPagingSource.PAGE_SIZE,
        ),
    ) {
        pagingSourceFactory.create()
    }.flow.cachedIn(viewModelScope)
}

typealias FlowPagingDataString = Flow<PagingData<String>>
