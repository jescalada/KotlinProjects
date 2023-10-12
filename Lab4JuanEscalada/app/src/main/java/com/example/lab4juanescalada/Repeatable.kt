package com.example.lab4juanescalada

interface Repeatable {
    // Abstract property
    var repeatNum: Int
    fun repeat(times: Int, missionListener: MissionListener): Unit
}