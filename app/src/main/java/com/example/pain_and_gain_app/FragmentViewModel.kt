package com.example.pain_and_gain_app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel : ViewModel() {

    val data = MutableLiveData<List<TopG>>()

    init {
        data.value = mutableListOf()
    }

    fun addTopG(topG: TopG) {
        val chadList = data.value?.toMutableList() ?: mutableListOf()
        chadList.add(topG)
        data.value = chadList
    }
}