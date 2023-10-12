package com.example.lab4juanescalada

class Dwarf : Minion {
    override val race: String
        get() = "Dwarf"
    override val baseHealth: Int
        get() = 8
    override val baseSpeed: Int
        get() = 2
    override val backpackSize: Int
        get() = 8
    override val catchphrase: String
        get() = "Where's me trusty ol hammer?"
}