package com.example.deadlinebot

import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import kotlinx.coroutines.delay
import java.time.LocalDateTime

object ListenerHelper {

    /**
     * This function is called when the bot is ready to start receiving events.
     *
     * @param kord The Kord instance that is ready to start receiving events.
     */
    fun onMessageCreateEvent(kord: Kord, status: Status) {
        kord.on<MessageCreateEvent> { // runs every time a message is created that our bot can read

            // ignore other bots, even ourselves. We only serve humans here!
            if (message.author?.isBot != false) return@on

            // check if our command is being invoked
            if (message.content[0] != '!') return@on

            // get the command (first word after the !)
            val split = message.content.split(" ")
            val command = split[0].substring(1)
            val args = split.drop(1)

            // interpret the command
            val response = CommandInterpreter.interpretCommand(command, args, status)

            // all clear, give them the pong!
            message.channel.createMessage(response)

            status.MessageChannelBehavior = message.channel
        }
    }

    /**
     * Listens for deadlines that are due or due in the next interval.
     *
     * @param status the bot's status
     */
    suspend fun deadlineIntervalListener(status: Status) {
        while (true) {
            checkDeadlineIntervalPassed(status)
            // Check every minute (account for execution time)
            delay(59990)
        }
    }

    /**
     * Checks if any deadlines are due or if any deadlines are due in the next interval.
     *
     * @param status the bot's status
     */
    private suspend fun checkDeadlineIntervalPassed(status: Status) {
        // Check if current time (match date, hours and minutes) plus possible intervals match any deadlines
        val currentTime = LocalDateTime.now()
        val hourIntervals = status.settings["interval"]?.replace("[", "")?.replace("]", "")?.split(",")

        status.deadlines.forEach() {
            // Check if deadline is due
            if (currentTime.year == it.date.year && currentTime.month == it.date.month && currentTime.dayOfMonth == it.date.dayOfMonth && currentTime.hour == it.date.hour && currentTime.minute == it.date.minute) {
                status.MessageChannelBehavior?.createMessage("${it.name} is due!")
            }

            // Check if any interval threshold is passed
            for (interval in hourIntervals!!) {
                val intervalInt = interval.trim().toInt()
                val intervalDateTime = it.date.minusHours(intervalInt.toLong())

                if (currentTime.year == intervalDateTime.year && currentTime.month == intervalDateTime.month && currentTime.dayOfMonth == intervalDateTime.dayOfMonth && currentTime.hour == intervalDateTime.hour && currentTime.minute == intervalDateTime.minute) {
                    status.MessageChannelBehavior?.createMessage("**${it.name}** is due in **$intervalInt hours!**")
                }
            }
        }
    }
}