package com.example.lab4juanescalada

import kotlin.properties.Delegates

class Hunt(private val minion: Minion, private val item: Item? = null) : Mission(minion, item), Repeatable {
    override fun determineMissionTime(): Int {
        return (minion.baseHealth + minion.baseSpeed + ( item?.timeModifier ?: 0 )) * (0..4).random()
    }

    override fun reward(time: Int): String {
        if (minion is Elf)
            return minion.huntReward(time)

        return when (time) {
            in 11..20 -> "a mouse"
            in 21..30 -> "a fox"
            in 31..40 -> "a buffalo"
            in 41..60 -> "a dinosaur"
            else -> "nothing"
        }
    }

    override var repeatNum: Int by Delegates.vetoable(0) { _, _, new ->
        if (new > 3) println("A minion cannot repeat a hunt more than 3 times!")
        new <= 3
    }

    override fun repeat(times: Int, missionListener: MissionListener) {
        repeatNum = times
        println("Repeating a hunt $repeatNum times...")
        for (i in 1..repeatNum) {
            start(missionListener)
        }
    }

}