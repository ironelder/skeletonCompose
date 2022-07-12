package com.ironelder.skeletoncompose

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface MainViewModel : BaseViewModel {

}

@HiltViewModel
class MainViewModelImpl @Inject constructor() : MainViewModel, ViewModel() {
}