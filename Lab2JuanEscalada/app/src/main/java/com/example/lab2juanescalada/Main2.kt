package com.example.lab2juanescalada

/*
    Juan Escalada
    A01285535
 */

fun main() {
    val operation1 = ::process
    println(operation1("Bits", 40))

    // Exercise 1: Call the code with a lambda (anonymous) function instead of function reference
    val operation2 = { type: String, amount: Int -> "...Processing $amount $type" }
    println(operation2("Bits", 40))

    // Exercise 2: Add a greet function below to print "Class Activity 2: Hello World"
    greet("Class Activity 2") {
        "$it World"
    }
}

fun process(type: String, amount: Int): String {
    return "...Processing $amount $type"
}

fun greet(arg1: String, arg2: (String) -> String) {
    println("$arg1: ${arg2("Hello")}")
}