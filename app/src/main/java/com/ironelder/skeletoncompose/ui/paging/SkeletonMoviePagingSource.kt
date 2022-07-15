package com.ironelder.skeletoncompose.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ironelder.skeletoncompose.data.CommonResult
import com.ironelder.skeletoncompose.usecase.GetCommonDataUseCase
import javax.inject.Inject

class SkeletonMoviePagingSource @Inject constructor(private val useCase: GetCommonDataUseCase) :
    PagingSource<Int, CommonResultPagingModel>() {
    override fun getRefreshKey(state: PagingState<Int, CommonResultPagingModel>): Int? =
        state.anchorPosition?.minus(1)

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CommonResultPagingModel> {
        return try {
            val next = params.key ?: 1
            val response = useCase.invoke(next).getOrThrow()
            LoadResult.Page(
                data = response.results
                    .filter { !it.posterPath.isNullOrEmpty() }
                    .map(CommonResult::resultToPagingMapper),
                prevKey = if (next == 1) null else next - 1,
                nextKey = if (next > response.totalPages) null else response.page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}