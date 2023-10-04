package com.example.lab2juanescalada

/*
    Juan Escalada
    A01285535
 */

fun main() {
    printWordData("The Quick Brown Fox Went Over The Lazy Dog Cat Horse TESTING")
}

/**
 *  Returns a list of indivdual words in a String
 *
 *  @param sentence a String containing multiple words
 *  @return a List<String> containing each word in the sentence
 */
fun split(sentence: String): Array<String> {
    return sentence.split(" ").toTypedArray()
}

/**
 * Returns a list of the lengths of each word in a String
 *
 * @param sentence a String containing multiple words
 * @return a List<Int> containing the length of each word in the sentence
 */
fun lengths(sentence: String): List<Int> {
    val words = split(sentence)
    val lengths = mutableListOf<Int>()
    for (word in words) {
        lengths.add(word.length)
    }
    return lengths
}

/**
 * Returns a list of the longest words in a String
 *
 * @param sentence a String containing multiple words
 * @return a List<String> containing the longest words in the sentence
 */
fun longestWords(sentence: String): Set<String> {
    val words = split(sentence)
    val lengths = lengths(sentence)
    val longestWords = mutableSetOf<String>()
    val maxLength = lengths.maxOrNull()
    var i = 0
    while (i < lengths.size) {
        if (lengths[i] == maxLength) {
            longestWords.add(words[i])
        }
        i++
    }
    return longestWords
}

/**
 * Returns a list of the shortest words in a String
 *
 * @param sentence a String containing multiple words
 * @return a List<String> containing the shortest words in the sentence
 */
fun shortestWords(sentence: String): Set<String> {
    val words = split(sentence)
    val lengths = lengths(sentence)
    val shortestWords = mutableSetOf<String>()
    val minLength = lengths.minOrNull()
    var i = 0
    lengths.forEach() {
        if (it == minLength) {
            shortestWords.add(words[i])
        }
        i++
    }
    return shortestWords
}

/**
 * Prints the data of a String using the functions above
 *
 * @param sentence a String containing multiple words
 */
fun printWordData(sentence: String) {
    println("Words: ${split(sentence).contentToString()}")
    println("Word lengths: ${lengths(sentence)}")
    println("Longest word(s): ${longestWords(sentence)}")
    println("Shortest word(s): ${shortestWords(sentence)}")
}


