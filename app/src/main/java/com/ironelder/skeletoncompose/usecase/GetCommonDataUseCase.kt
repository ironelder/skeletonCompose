package com.ironelder.skeletoncompose.usecase

import com.ironelder.skeletoncompose.data.BookRemoteRepository
import com.ironelder.skeletoncompose.data.model.SearchBookResultModel
import com.ironelder.skeletoncompose.ui.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetSearchBookDataUseCase @Inject constructor(
    private val repository: BookRemoteRepository,
    coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : UseCase<SearchQuery, SearchBookResultModel>(coroutineDispatcher) {
    override suspend fun execute(param: SearchQuery): SearchBookResultModel =
        repository.getSearchBookResult(query = param.query, page = param.page)
}

data class SearchQuery(val query: String, val page: Int)