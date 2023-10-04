package com.example.lab4juanescalada

class Hunt(private val minion: Minion) : Mission(minion), Repeatable {
    override fun determineMissionTime(): Int {
        return minion.baseHealth * minion.baseSpeed * (0..4).random()
    }

    override fun reward(): String {
        return when (determineMissionTime()) {
            in 11..20 -> "a mouse"
            in 21..30 -> "a fox"
            in 31..50 -> "a buffalo"
            else -> "nothing"
        }
    }

    override fun repeat(times: Int, missionListener: MissionListener) {
        for (i in 1..times) {
            start(missionListener)
        }
    }

}