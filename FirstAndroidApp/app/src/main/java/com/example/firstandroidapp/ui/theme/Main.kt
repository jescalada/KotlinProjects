package com.example.firstandroidapp.ui.theme

import kotlin.math.pow

const val MAGIC_NUMBER = 42

fun main() {
    val greeting = "Hello World!"
    println(greeting)
    fun test(value: Int) = println("$greeting Testing inline functions. My value is $value")
    val testLambda = { value: Int -> println("$greeting Testing inline functions. My value is $value") }

    test(MAGIC_NUMBER)
    testLambda(MAGIC_NUMBER)

    // Testing lambda functions with aggregate functions
    val list = listOf(1, 2, 3, 4, 5)
    val sum = list.sum()
    val sumByLambda = list.sumOf { it * 2 }
    println("$greeting The sum of $list is $sum")
    println("$greeting The sum of $list is $sumByLambda")

    // Strings are iterable
    greeting.forEach { print("${it.code} ") }.also { println() }
    greeting.sumOf { it.code }.also { println(it) }

    // Testing equality
    val list2 = listOf(5, 4, 3, 2, 1).sorted()
    println("$greeting The lists are equal: ${list == list2}")

    // Testing destructuring
    val (first, second, third) = list
    println("$greeting The first element is $first, the second is $second, and the third is $third")

    // Testing destructuring with maps
    val map = mapOf("first" to 1, "second" to 2, "third" to 3)
    for ((key, value) in map) {
        println("$greeting The key is $key and the value is $value")
    }

    val a = if (greeting === "Hello World!") 2.0 else 3.0
    val b = 4.0

    // Testing math
    a.pow(b).also { println("$greeting $a^$b = $it") }

    // Define a map of strings to maps of strings to strings
    val mapOfMaps = mutableMapOf(
        "first" to mapOf("first" to "1", "second" to "2", "third" to "3"),
        "second" to mapOf("first" to "4", "second" to "5", "third" to "6"),
        "third" to mapOf("first" to "7", "second" to "8", "third" to "9")
    )

    // Print the value of the key "second" in the map with the key "first"
    println("$greeting ${mapOfMaps["first"]?.get("second")}")

    // Add a new key-value pair to the map with the key "fourth"
    mapOfMaps["fourth"] = mapOf("first" to "10", "second" to "11", "third" to "12")

    println("ball" in "a".."b")
    println("ball" in "a".."c")

}