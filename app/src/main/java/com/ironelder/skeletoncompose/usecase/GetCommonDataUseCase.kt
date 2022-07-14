package com.ironelder.skeletoncompose.usecase

import com.ironelder.skeletoncompose.data.CommonModel
import com.ironelder.skeletoncompose.data.CommonRepository
import com.ironelder.skeletoncompose.ui.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetCommonDataUseCase @Inject constructor(
    private val repository: CommonRepository,
    coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : UseCase<Int, CommonModel>(coroutineDispatcher) {
    override suspend fun execute(param: Int): CommonModel = repository.getCommonData(page = param)
}