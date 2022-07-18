package com.ironelder.skeletoncompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ironelder.skeletoncompose.ui.paging.SearchBookPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

interface MainViewModel : BaseViewModel {
}

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val searchBookPagingSource: SearchBookPagingSource
) : MainViewModel, ViewModel() {

    private val dataChangeTrigger = flow {
        emit(Unit)
        emitAll(refreshFlow)
    }
    private val _isRefresh = MutableStateFlow(false)
    val isRefresh: StateFlow<Boolean> = _isRefresh
    private val refreshFlow = MutableSharedFlow<Unit>()

    val getSearchBookList = dataChangeTrigger.flatMapLatest {
        val elapsedTime = System.currentTimeMillis()
        searchBookPagingSource.searchQuery = "Android"
        Pager(config = PagingConfig(pageSize = 20), pagingSourceFactory = ::searchBookPagingSource)
            .flow
            .cachedIn(viewModelScope)
            .catch { println(it.localizedMessage) }
            .map {
                viewModelScope.launch {
                    val fetchTime = System.currentTimeMillis() - elapsedTime
                    if (fetchTime - elapsedTime < 300) {
                        delay(300 - fetchTime)
                        _isRefresh.emit(false)
                    }
                }
                it
            }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), PagingData.empty())
    }
}