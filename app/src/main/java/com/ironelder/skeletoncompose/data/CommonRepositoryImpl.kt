package com.ironelder.skeletoncompose.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CommonRepositoryImpl @Inject constructor(private val api: CommonApi) : CommonRepository {
    override suspend fun getCommonData(page: Int): CommonModel {
        val model = api.getUpcomingMovie(page)
        val t = model.execute().body()
        println("ironelder model = $t")
        return model.execute().body() as CommonModel
    }
}