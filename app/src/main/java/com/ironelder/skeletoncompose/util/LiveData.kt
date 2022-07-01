package com.ironelder.skeletoncompose.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> LiveData<T>.set(value: T) {
    (this as? MutableLiveData)?.value = value
}