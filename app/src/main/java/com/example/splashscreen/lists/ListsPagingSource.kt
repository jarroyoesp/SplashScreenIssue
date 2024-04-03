package com.example.splashscreen.lists

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.splashscreen.interactor.SplashScreenInteractor
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ListsPagingSource @AssistedInject constructor(
    private val splashScreenInteractor: SplashScreenInteractor,
) : PagingSource<Int, String>() {
    @AssistedFactory
    interface Factory {
        fun create(): ListsPagingSource
    }

    override fun getRefreshKey(state: PagingState<Int, String>): Int = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        splashScreenInteractor.hide()
        return LoadResult.Page(
            data = List(6) { "item $it" },
            prevKey = null,
            nextKey = null,
            itemsBefore = LoadResult.Page.COUNT_UNDEFINED,
            itemsAfter = 0,
        )
    }
}
