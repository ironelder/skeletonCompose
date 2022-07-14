package com.ironelder.skeletoncompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ironelder.skeletoncompose.usecase.GetCommonDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

interface MainViewModel : BaseViewModel {
    fun getCommonData()
}

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val useCase: GetCommonDataUseCase
) : MainViewModel, ViewModel() {

    override fun getCommonData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val commonData = useCase.invoke(1).getOrThrow()
                println("ironelder result = $commonData")
            } catch (e:Exception) {
                println("ironelder Exception = $e")
            }
        }
    }

}