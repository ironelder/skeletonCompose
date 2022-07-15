package com.ironelder.skeletoncompose.ui.paging

import com.ironelder.skeletoncompose.data.CommonResult
import kotlin.random.Random

data class CommonResultPagingModel(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Long = Random.nextLong(Long.MAX_VALUE),
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String?,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)

fun CommonResult.resultToPagingMapper() = CommonResultPagingModel(
    adult,
    backdropPath,
    genreIds,
    id,
    originalLanguage,
    originalTitle,
    overview,
    popularity,
    posterPath.toString(),
    releaseDate,
    title,
    video,
    voteAverage,
    voteCount
)