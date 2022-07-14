package com.ironelder.skeletoncompose.ui.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ironelder.skeletoncompose.MainViewModelImpl
import com.ironelder.skeletoncompose.getActivityViewModel


@Composable
fun HomeScreen(viewModel: MainViewModelImpl = getActivityViewModel()) {
    Text(text = "Hello!")
    viewModel.getCommonData()
}