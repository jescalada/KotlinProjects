package com.example.lab4juanescalada

interface MissionListener {
    fun missionStart(minion: Minion): Unit
    fun missionProgress(): Unit
    fun missionCompleted(minion: Minion, reward: String): Unit
}