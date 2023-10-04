package com.example.lab4juanescalada

/*
    Juan Escalada
    A01285535
 */

fun main() {
    val human = Human()
    val dwarf = Dwarf()
    val archer = Archer()

    val gatheringMission1 = Gather(human)
    val huntingMission = Hunt(archer)
    val gatheringMission2 = Gather(dwarf)

    // Pass a MissionListener as an anonymous class
    gatheringMission1.start(
        object : MissionListener {
            override fun missionStart(minion: Minion) {
                val minionRaceParsed = if (minion.race[0].lowercase() in "aeiouy") "An ${minion.race}" else "A ${minion.race}"
                println(minion.catchphrase)
                println("$minionRaceParsed was sent off to gather some resources!")
            }

            override fun missionProgress() {
                println("...\n...\n...")
            }

            override fun missionCompleted(minion: Minion, reward: String) {
                val minionRaceParsed = if (minion.race[0].lowercase() in "aeiouy") "An ${minion.race}" else "A ${minion.race}"
                println("$minionRaceParsed has returned from gathering, and found $reward!\n" +
                        "=====================")
            }
        }
    )

    huntingMission.repeat(3,
        object : MissionListener {
            override fun missionStart(minion: Minion) {
                val minionRaceParsed = if (minion.race[0].lowercase() in "aeiouy") "An ${minion.race}" else "A ${minion.race}"
                println(minion.catchphrase)
                println("\n$minionRaceParsed started a new hunt!")
            }

            override fun missionProgress() {
                println("...\n...\n...")
            }

            override fun missionCompleted(minion: Minion, reward: String) {
                val minionRaceParsed = if (minion.race[0].lowercase() in "aeiouy") "An ${minion.race}" else "A ${minion.race}"
                println("$minionRaceParsed has returned from a hunt, and found $reward!\n" +
                        "=====================")
            }
        }
    )

    gatheringMission2.start(
        object : MissionListener {
            override fun missionStart(minion: Minion) {
                val minionRaceParsed = if (minion.race[0].lowercase() in "aeiouy") "An ${minion.race}" else "A ${minion.race}"
                println(minion.catchphrase)
                println("$minionRaceParsed was sent off to gather some resources!")
            }

            override fun missionProgress() {
                println("...\n...\n...")
            }

            override fun missionCompleted(minion: Minion, reward: String) {
                val minionRaceParsed = if (minion.race[0].lowercase() in "aeiouy") "An ${minion.race}" else "A ${minion.race}"
                println("$minionRaceParsed has returned from gathering, and found $reward!\n" +
                        "=====================")
            }
        }
    )
}