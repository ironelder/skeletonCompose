package com.ironelder.skeletoncompose.data

interface CommonRepository {
    suspend fun getCommonData(page: Int): CommonModel
}