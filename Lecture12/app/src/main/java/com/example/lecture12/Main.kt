package com.example.lecture12

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

//fun main() {
//    val sequence = sequenceOf(1, 2, 3, 4, 5)
//        .filter { it % 2 == 0 }
//        .map { it + 1 }
//        .take(2)
//
//    sequence.toList().forEach(::println)
//
//    val story = sequence {
//        yield("Once upon a time")
//        yield("there was a programmer")
//        yield("who loved Kotlin")
//    }
//    story.forEach(::println)
//
//    val flow = flow {
//        delay(1000L)
//        emit("The quick brown fox")
//        delay(1000L)
//        emit("jumps over the lazy dog")
//    }
//
//    runBlocking {
//        flow.collect { println(it) }
//    }
//
//}

data class Sponge(var name: String?)

// Create a sponge with a name, without using "it" keyword
fun createSponge(consumer: Sponge.() -> Unit): Sponge {
    val sponge = Sponge(null)
    consumer(sponge)
    return sponge
}
// Juan Escalada A01285535
fun main() {
    val sponge = createSponge {
        name = "Spongebob"
    }

    println(sponge)
}