package com.morenocreativo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {


    var num = Random.nextInt()
    fun cambiarNumero() {
        num = Random.nextInt()
    }

    val numLiveData: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val stateLiveData: MutableLiveData<MainActivityState> by lazy {
        MutableLiveData<MainActivityState>()
    }

    fun cambiarNumeroLiveData() {
        numLiveData.value = Random.nextInt()
    }

    fun cambiarState() {
        viewModelScope.launch {
            stateLiveData.value = MainActivityState.Loading
            delay(2000)
//        si número positivo, success - negativo error
            val num = Random.nextInt()
            if (num >= 0) {
                stateLiveData.value = MainActivityState.Success(num)
            } else {
                stateLiveData.value = MainActivityState.Error("Error: $num")
            }
        }

    }

    sealed class MainActivityState {
        data class Success(val num: Int) : MainActivityState()
        data class Error(val message: String) : MainActivityState()
        object Loading : MainActivityState()
    }
}