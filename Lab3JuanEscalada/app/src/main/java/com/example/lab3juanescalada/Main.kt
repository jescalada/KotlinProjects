package com.example.lab3juanescalada

/*
    Juan Escalada
    A01285535
 */

fun main() {
    val facts = mapOf<Int, String>(
        1492 to "Christopher Columbus discovers America",
        1601 to "William Shakespeare writes Hamlet",
        1632 to "Galileo discovered the acceleration of gravity",
        1838 to "The light-year is first used as a measurement in astronomy",
        2020 to "The COVID-19 pandemic begins"
    )
    val keyToPair = { key: Int, map: Map<Int, String> -> Pair(key, map[key]!!) }

    printPair(keyToPair(1492, facts))
    printMap(facts, 1)
    applyFunction(keyToPair(1632, facts)) { pair -> printPair(pair) }
    applyToKey(1838, facts) { key, value -> printPair(Pair(key, value)) }
    applyFunction(keyToPair(2020, facts), fun (pair: Pair<Int, String>) { returnPrinter()(pair) })

    println()

    applyToKey(1492, facts) { _, value -> println(value) }
    applyFunction(keyToPair(1838, facts), fun (pair: Pair<Int, String>) { println(pair.second) })
    applyToKey(1632, facts) { _, value -> println(value) }
    applyToKey(1838, facts) { _, value -> println(value) }
    applyToKey(2020, facts) { _, value -> println(value) }
}

// Function that receives a pair of Int, String and prints them
fun printPair(pair: Pair<Int, String>) {
    println("${pair.first}=${pair.second}")
}

// Function that receives a map of Int, String and an index and prints the key, value pair of the map at the index
fun printMap(map: Map<Int, String>, index: Int) {
    println("${map.keys.elementAt(index)}=${map.values.elementAt(index)}")
}

// Function that receives a pair of Int, String and a function and applies the function to the pair
fun applyFunction(pair: Pair<Int, String>, function: (Pair<Int, String>) -> Unit) {
    function(pair)
}

// Function that returns a function that receives a pair of Int, String and prints them
fun returnPrinter(): (Pair<Int, String>) -> Unit {
    return ::printPair
}

// Function that receives a key and does something with the value
fun applyToKey(key: Int, map: Map<Int, String>, function: (Int, String) -> Unit) {
    function(key, map[key]!!)
}