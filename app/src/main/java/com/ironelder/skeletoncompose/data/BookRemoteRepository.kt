package com.ironelder.skeletoncompose.data

import com.ironelder.skeletoncompose.data.model.SearchBookResultModel

interface BookRemoteRepository {
    suspend fun getSearchBookResult(
        query: String,
        page: Int,
        sort: String = "sim",
        display: Int = 20,
    ): SearchBookResultModel
}