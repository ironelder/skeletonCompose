package com.ironelder.skeletoncompose.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ironelder.skeletoncompose.data.model.BookResultItem
import com.ironelder.skeletoncompose.usecase.GetSearchBookDataUseCase
import com.ironelder.skeletoncompose.usecase.SearchQuery
import javax.inject.Inject

class SearchBookPagingSource @Inject constructor(private val useCase: GetSearchBookDataUseCase) :
    PagingSource<Int, SearchBookPagingModel>() {

    var searchQuery = ""

    override fun getRefreshKey(state: PagingState<Int, SearchBookPagingModel>): Int? =
        state.anchorPosition?.minus(1)

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchBookPagingModel> {
        return try {
            val next = params.key ?: 1
            val response = useCase.invoke(SearchQuery(query = searchQuery, page = next)).getOrThrow()
            LoadResult.Page(
                data = response.items
                    .filter { it.isbn.isNotEmpty() }
                    .map(BookResultItem::resultToPagingMapper),
                prevKey = if (next == 1) null else next - 1,
                nextKey = if (next > response.total) null else response.start.plus(response.display)
            )
        } catch (e: Exception) {
            println("ironelder = $e")
            LoadResult.Error(e)
        }
    }
}