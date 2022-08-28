package com.ironelder.skeletoncompose.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchBookResultModel(
    @SerialName("display")
    val display: Int,
    @SerialName("items")
    val items: List<BookResultItem>,
    @SerialName("lastBuildDate")
    val lastBuildDate: String,
    @SerialName("start")
    val start: Int,
    @SerialName("total")
    val total: Int
)

@Serializable
data class BookResultItem(
    @SerialName("author")
    val author: String,
    @SerialName("description")
    val description: String,
    @SerialName("discount")
    val discount: String,
    @SerialName("image")
    val image: String,
    @SerialName("isbn")
    val isbn: String,
    @SerialName("link")
    val link: String,
    @SerialName("pubdate")
    val pubdate: String,
    @SerialName("publisher")
    val publisher: String,
    @SerialName("title")
    val title: String
)