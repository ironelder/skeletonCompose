package com.ironelder.skeletoncompose.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CommonModel(
    @SerialName("dates")
    val dates: CommonDates? = null,
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val results: List<CommonResult>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
)

@Serializable
data class CommonDates(
    @SerialName("maximum")
    val maximum: String?,
    @SerialName("minimum")
    val minimum: String?
)

@Serializable
data class CommonResult(
    @SerialName("adult")
    val adult: Boolean,
    @SerialName("backdrop_path")
    val backdropPath: String = "",
    @SerialName("genre_ids")
    val genreIds: List<Int>,
    @SerialName("id")
    val id: Long,
    @SerialName("original_language")
    val originalLanguage: String,
    @SerialName("original_title")
    val originalTitle: String,
    @SerialName("overview")
    val overview: String,
    @SerialName("popularity")
    val popularity: Double,
    @SerialName("poster_path")
    val posterPath: String? = null,
    @SerialName("release_date")
    val releaseDate: String? = null,
    @SerialName("title")
    val title: String,
    @SerialName("video")
    val video: Boolean,
    @SerialName("vote_average")
    val voteAverage: Double,
    @SerialName("vote_count")
    val voteCount: Int
)