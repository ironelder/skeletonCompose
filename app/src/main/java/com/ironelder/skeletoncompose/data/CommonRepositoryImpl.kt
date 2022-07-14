package com.ironelder.skeletoncompose.data

import retrofit2.await
import javax.inject.Inject

class CommonRepositoryImpl @Inject constructor(private val api: CommonApi) : CommonRepository {
    override suspend fun getCommonData(page: Int): CommonModel {
        return api.getUpcomingMovie(page).await()
    }
}