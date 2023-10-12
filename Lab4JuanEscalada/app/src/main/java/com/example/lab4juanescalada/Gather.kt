package com.example.lab4juanescalada

import kotlin.properties.Delegates

class Gather(private val minion: Minion, private val item: Item? = null) : Mission(minion, item), Repeatable {
    override fun determineMissionTime(): Int {
        return (minion.baseHealth + minion.baseSpeed + ( item?.timeModifier ?: 0 )) * (0..4).random()
    }

    override fun reward(time: Int): String {
        return when (time) {
            in 10..21 -> "bronze"
            in 22..33 -> "silver"
            in 34..44 -> "gold"
            in 45..60 -> "diamond"
            else -> "nothing"
        }
    }

    override var repeatNum: Int by Delegates.vetoable(3) { _, _, new ->
        if (new > 3) println("A minion cannot repeat gathering more than 3 times!")
        new <= 3
    }

    override fun repeat(times: Int, missionListener: MissionListener) {
        repeatNum = times
        println("Repeating gathering $repeatNum times...")
        for (i in 1..repeatNum) {
            start(missionListener)
        }
    }

}