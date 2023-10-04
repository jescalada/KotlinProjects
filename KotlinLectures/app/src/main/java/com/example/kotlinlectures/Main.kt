package com.example.kotlinlectures

import kotlin.math.pow

fun main() {
    println("10" + 6)
    println(10 + "6".toInt())  // Must be converted to Int
    // These are some conversion functions: toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble(), toChar()

    // Creating arrays
    val myArray = arrayOf(1, 1.23, "Doug")
    val myArray2 = arrayOf<Int>(1, 2, 3, 4, 5)
    println(myArray.contentToString())

    // Creating lists
    val myList = listOf(1, 2, 3, 4, 5)
    val myList2 = mutableListOf(1, 2, 3, 4, 5)
    println(myList2.indexOf(3))
    println(myList2.contains(3))
    println(myList2.first())

    // Partioning is a way to split a list into two lists based on a condition
    val(myList3, myList4) = myList2.partition { it > 3 }
    println("List 3: $myList3, List 4: $myList4")

    for (num in myList2) {
        val myDouble = num.toDouble().pow(2.0)
        println(myDouble)
    }

    // Ranges
    val myRange = 1..10
    val myRange2 = 1.rangeTo(10)
    val myRange3 = 10.downTo(1)
    val myRange4 = 1..10 step 2
    val myRange5 = 'A'..'E'

    for (letter in myRange5) {
        print("$letter ")
    }

    // Juan Escalada
    // A01285535

    // Activity 1
    for (num in 1..10) {
        if (num % 2 != 0) continue else println(num)
    }

    // Activity 2
    var i = 0
    while (i < 10) {
        if (i++ % 2 == 0) println(i) else continue
    }

    // Activity 3
    for (num in 1..100) {
        if (num % 3 != 0) continue else println(num)
    }

    // Activity 4
    println((0..100 step 2).sum())
}