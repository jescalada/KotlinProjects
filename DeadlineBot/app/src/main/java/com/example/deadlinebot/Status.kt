package com.example.deadlinebot

import dev.kord.core.behavior.channel.MessageChannelBehavior

/**
 * Data class for the bot's status.
 * @param deadlines the deadlines the bot is tracking
 * @param isRunning whether the bot is running or not
 * @param settings the settings for the bot
 */
data class Status(
    val deadlines: MutableList<Deadline>,
    var isRunning: Boolean,
    val settings: MutableMap<String, String>
) {
    var MessageChannelBehavior: MessageChannelBehavior? = null

    /**
     * Adds a deadline to the list of deadlines.
     * @param deadline the deadline to add
     * @return the response to the add command
     */
    fun addDeadline(deadline: Deadline) {
        deadlines.add(deadline)
    }

    /**
     * Removes a deadline from the list of deadlines.
     * @param deadline the deadline to remove
     * @return the response to the remove command
     */
    fun removeDeadline(deadline: Deadline) {
        deadlines.remove(deadline)
    }

    /**
     * Updates a setting.
     * @param setting the setting to update
     * @param value the new value for the setting
     */
    fun updateSetting(setting: String, value: String) {
        settings[setting] = value
    }
}