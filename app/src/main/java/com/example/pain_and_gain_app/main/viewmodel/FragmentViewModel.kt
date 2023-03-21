package com.example.pain_and_gain_app.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pain_and_gain_app.model.NetWorth
import com.example.pain_and_gain_app.model.TopG

class FragmentViewModel : ViewModel() {

    val data = MutableLiveData<List<TopG>>()

    init {
        data.value = mutableListOf(
            TopG(
                firstname = "Matej",
                lastName = "Balog",
                age = 21,
                nationality = "Croatian",
                placeOfBirth = "Zagreb",
                placeOfResidence = "Zagreb",
                height = 178,
                weight = 65,
                netWorth = NetWorth.BROKIE,
                benchWeight = 100, // cap
                squatWeight = 200, // cap
                nmrOfGirfriends = "0 (incel)",
                colorOfYourBugatti = "transparent",
                pictureId = 0
            ),
            TopG(
                firstname = "Andrew",
                lastName = "Tate",
                age = 35,
                nationality = "British",
                placeOfBirth = "New York",
                placeOfResidence = "Buchurest",
                height = 190,
                weight = 90,
                netWorth = NetWorth.TOP_G,
                benchWeight = 200,
                squatWeight = 200,
                nmrOfGirfriends = ">5 (Top G)",
                colorOfYourBugatti = "golden rod",
                pictureId = 0
            ),
            TopG(
                firstname = "Zoomer",
                lastName = "Tiktoker",
                age = 18,
                nationality = "American",
                placeOfBirth = "Los Angeles",
                placeOfResidence = "Miami",
                height = 172,
                weight = 60,
                netWorth = NetWorth.WAGE_SLAVE,
                benchWeight = 200,
                squatWeight = 200,
                nmrOfGirfriends = "1 (simp)",
                colorOfYourBugatti = ":(",
                pictureId = 2
            )
        )
    }

    fun addTopG(topG: TopG) {
        val chadList = data.value?.toMutableList() ?: mutableListOf()
        chadList.add(topG)
        data.value = chadList
    }
}