package com.ironelder.skeletoncompose.data

import com.ironelder.skeletoncompose.data.model.SearchBookResultModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchBookApi {

    @GET("v1/search/book.json")
    fun searchBook(
        @Query("query") query: String,
        @Query("start") page: Int,
        @Query("sort") sort: String,
        @Query("display") display:Int,
    ): Call<SearchBookResultModel>

}