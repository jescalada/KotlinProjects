package com.example.lab4juanescalada

class Orc(elfDelegate: Elf): Minion by elfDelegate {
    override val race: String
        get() = "Orc"

    override val catchphrase: String
        get() = "ARRGH!"
}