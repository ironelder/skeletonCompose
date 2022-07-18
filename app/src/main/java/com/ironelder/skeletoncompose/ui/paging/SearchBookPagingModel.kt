package com.ironelder.skeletoncompose.ui.paging

import com.ironelder.skeletoncompose.data.model.BookResultItem

data class SearchBookPagingModel(
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

fun BookResultItem.resultToPagingMapper() = SearchBookPagingModel(
    author,
    description,
    discount,
    image,
    isbn,
    link,
    price,
    pubdate,
    publisher,
    title
)