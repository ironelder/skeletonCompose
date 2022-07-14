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

    @GET("3/genre/movie/list")
    fun getGenreList(): Call<Any>

    @GET("3/discover/movie")
    fun getGenreMovies(
        @Query("page") page: Int,
        @Query("with_genres") withGenres: String
    ): Call<Any>

    // GET /trending/{media_type}/{time_window}
    // media_type = movie
    // time_window = day, week
    @GET("3/trending/{media_type}/{time_window}")
    fun getTrendingMovie(
        @Path("media_type") mediaType: String = "movie",
        @Path("time_window") timeWindow: String = "week",
        @Query("page") page: Int
    ): Call<Any>
}