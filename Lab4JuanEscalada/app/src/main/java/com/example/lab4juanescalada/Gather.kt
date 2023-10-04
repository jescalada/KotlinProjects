package com.example.lab4juanescalada

class Gather(private val minion: Minion) : Mission(minion), Repeatable {
    override fun determineMissionTime(): Int {
        return minion.backpackSize * minion.baseSpeed * (0..4).random()
    }

    override fun reward(): String {
        return when (determineMissionTime()) {
            in 10..21 -> "bronze"
            in 22..33 -> "silver"
            in 34..50 -> "gold"
            else -> "nothing"
        }
    }

    override fun repeat(times: Int, missionListener: MissionListener) {
        for (i in 1..times) {
            start(missionListener)
        }
    }

}