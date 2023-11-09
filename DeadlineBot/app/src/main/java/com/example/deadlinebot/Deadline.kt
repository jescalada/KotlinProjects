package com.example.deadlinebot

import java.time.LocalDateTime

/**
 * Data class for a deadline.
 */
data class Deadline(
    val name: String,
    val description: String,
    val date: LocalDateTime
)