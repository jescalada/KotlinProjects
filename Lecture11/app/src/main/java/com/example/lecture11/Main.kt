package com.example.lecture11

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    val startTime = System.currentTimeMillis()
    print("Hello, ")
    myCoroutine()
    println("Execution time: ${System.currentTimeMillis() - startTime} ms")
}

fun myCoroutine() {
    runBlocking {
        val job = launch {
            myDelay()
            print("This is a coroutine")
        }
        val deferredJob = async {
            myDelay()
            "This is a deferred coroutine."
        }
        println("World!")
        job.join()
        println("!!!")
        println(deferredJob.await())
    }
}

fun myCoroutine2() {
    val scope = CoroutineScope(context = Dispatchers.Main)
    scope.launch {
        val deferred = async {

        }
    }
}

/**
 * Juan Escalada
 *
 * 1.) 87451155
 * 2.) 87451155
 * 3.) 87451155
 */



suspend fun myDelay() {
    delay(1000L)
}