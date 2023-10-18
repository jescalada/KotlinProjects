package com.example.deadlinebot

import dev.kord.core.Kord
import dev.kord.core.exception.KordInitializationException
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() = runBlocking {
    val token = DataHelper.loadBotTokenFromEnv("app/assets", "env")

    // Initialize bot
    val kord: Kord
    try {
        kord = Kord(token)
    } catch (e: KordInitializationException) {
        println("Invalid token. Please check your env file at app/assets/env.")
        return@runBlocking
    }

    val deadlines = DataHelper.loadDeadlinesFromFile("app/assets/deadlines.txt")
    val settings = mutableMapOf(
        "autoremind" to "true",
        "interval" to "[72, 24]"
    )

    val status = Status(deadlines, true, settings)

    // Register message listener and pass in the bot's status
    ListenerHelper.onMessageCreateEvent(kord, status)

    // Run deadline interval listener asynchronously to trigger reminders
    launch {
        ListenerHelper.deadlineIntervalListener(status)
    }

    // Log bot into Discord
    kord.login {
        // we need to specify this to receive the content of messages
        @OptIn(PrivilegedIntent::class)
        intents += Intent.MessageContent
    }
}