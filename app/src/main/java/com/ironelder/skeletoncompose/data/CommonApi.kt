package com.ironelder.skeletoncompose.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CommonApi {

    @GET("3/movie/upcoming")
    fun getUpcomingMovie(@Query("page") page: Int): Call<CommonModel>

    @GET("3/search/movie")
    fun searchMovie(@Query("page") page: Int, @Query("query") query: String): Call<Any>

}