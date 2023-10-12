package com.example.lab4juanescalada

class Elf: Minion {
    fun huntReward(time: Int): String {
        return when (time) {
            in 11..20 -> "a fish"
            in 21..30 -> "a forest bear"
            in 31..40 -> "an orc"
            in 41..60 -> "a troll"
            else -> "nothing"
        }
    }
    override val race: String
        get() = "Elf"
    override val baseHealth: Int
        get() = 2
    override val baseSpeed: Int
        get() = 8
    override val backpackSize: Int
        get() = 3
    override val catchphrase: String
        get() = "My arrows never miss!"
}