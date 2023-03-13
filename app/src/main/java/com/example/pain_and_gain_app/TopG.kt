package com.example.pain_and_gain_app

data class TopG(
    val firstname: String,
    val lastName: String,
    val age: Int,
    val nationality: String,
    val placeOfBirth: String,
    val placeOfResidence: String,
    val height: Int,
    val weight: Int,
    val netWorth: String,
    val benchWeight: Int,
    val squatWeight: Int,
    val nmrOfGirfriends: String,
    val colorOfYourBugatti: String
) {
    override fun toString(): String {
        val gfNumber = nmrOfGirfriends[0]
        val index = nmrOfGirfriends.indexOf('(')
        val gfStatus = nmrOfGirfriends.substring(index + 1, nmrOfGirfriends.length - 1)
        return "$firstname $lastName of nationality $nationality and age $age, located in $placeOfResidence.\nHis net worth gives him a status of " +
            "$netWorth and he has $gfNumber girlfriends, which makes him a $gfStatus"
    }
}

enum class NetWorth(val value: String) {
    BROKIE("<1000$"),
    DEBT_SLAVE(">1000$"),
    WAGE_SLAVE(">10000$"),
    STILL_POOR(">100000$"),
    TOP_G(">1000000$")
}