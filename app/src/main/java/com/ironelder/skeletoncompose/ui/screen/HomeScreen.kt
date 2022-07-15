package com.ironelder.skeletoncompose.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ironelder.skeletoncompose.MainViewModelImpl
import com.ironelder.skeletoncompose.getActivityViewModel
import com.ironelder.skeletoncompose.ui.base.LoadingItem
import com.ironelder.skeletoncompose.ui.base.LoadingView
import com.ironelder.skeletoncompose.ui.base.itemsIndexed
import com.ironelder.skeletoncompose.ui.base.setPagingStateListener


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(viewModel: MainViewModelImpl = getActivityViewModel()) {
//    Text(text = "Hello!")
    val test = "testText"

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("HomeScreen") },
            navigationIcon = {
                Icon(
                    painter = rememberVectorPainter(Icons.Filled.Favorite),
                    contentDescription = ""
                )
            },
            modifier = Modifier.fillMaxWidth(),
            elevation = 0.dp,
            actions = { }
        )
    }) {
        val commonList = viewModel.getMovieList.collectAsLazyPagingItems()
        val isRefresh by viewModel.isRefresh.collectAsState()
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = isRefresh),
            onRefresh = {
                //viewModelRefresh
            }
        ) {
            LazyVerticalGrid(cells = GridCells.Fixed(2)) {
                itemsIndexed(commonList) { data, position ->
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = data.title)
                        Text(text = data.overview)
                    }
                }
                setPagingStateListener(
                    commonList,
                    refresh = {
                        item { LoadingView(Modifier.fillParentMaxSize()) }
                        item { LoadingView(Modifier.fillParentMaxSize()) }
                    },
                    append = {
                        item { LoadingItem() }
                        item { LoadingItem() }
                    }
                )
            }
        }
    }
}