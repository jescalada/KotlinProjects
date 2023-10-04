package com.example.kotlinclass4

import java.util.Locale

class Character(private val name: String, private val friends: Int, private val occupation: String) {
    // Define custom getter for name
    val nameCapitalized: String
        get() = name.split(" ").joinToString { it.capitalize(Locale.ROOT) }

    fun displayInfo() {
        println("Name: $nameCapitalized \nFriends: $friends \nOccupation: $occupation")
    }
}