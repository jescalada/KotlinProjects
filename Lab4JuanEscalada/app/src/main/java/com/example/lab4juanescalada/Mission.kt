package com.example.lab4juanescalada

abstract class Mission(private val minion: Minion) {
    fun start(missionListener: MissionListener) {
        missionListener.missionStart(minion)
        val time = determineMissionTime()
        missionListener.missionProgress()
        missionListener.missionCompleted(minion, reward(time))
    }

    abstract fun determineMissionTime(): Int

    abstract fun reward(time: Int): String
}