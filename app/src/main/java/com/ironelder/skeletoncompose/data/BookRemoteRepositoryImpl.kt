package com.ironelder.skeletoncompose.data

import com.ironelder.skeletoncompose.data.model.SearchBookResultModel
import retrofit2.await
import javax.inject.Inject

class BookRemoteRepositoryImpl @Inject constructor(private val searchBookApi: SearchBookApi) :
    BookRemoteRepository {
    override suspend fun getSearchBookResult(
        query: String,
        page: Int,
        sort: String,
        display: Int
    ): SearchBookResultModel {
        return searchBookApi.searchBook(query, page, sort, display).await()
    }

}