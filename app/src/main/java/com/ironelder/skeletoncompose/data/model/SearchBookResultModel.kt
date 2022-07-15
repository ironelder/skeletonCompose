package com.ironelder.skeletoncompose.data.model

data class SearchBookResultModel(
    val display: Int,
    val items: List<BookResultItem>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)

data class BookResultItem(
    val author: String,
    val description: String,
    val discount: String,
    val image: String,
    val isbn: String,
    val link: String,
    val price: String,
    val pubdate: String,
    val publisher: String,
    val title: String
)