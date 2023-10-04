package com.example.lab1juanescalada

/*
    Juan Escalada
    A01285535
 */

val VERSION_NUM: Double = 0.2
val SLOGAN: String = "deliver with a smile"

fun startProgram(streetNum: Int, streetName: String) {
    val fullAddress: String? = when {
        VERSION_NUM >= 1.0 -> "%s %s, Glasgow, Scotland".format(streetNum, streetName)
        else -> {
            println("Starting Beta Version\n...\n...\n...")
            null
        }
    }
    println("""
                    Food Delivery Service v$VERSION_NUM
        
        Welcome to Glasgow's finest food delivery service, where we provide
        you with swift instructions on where to deliver your food.
        
                    Please deliver the food to:
                    
                    ${fullAddress?.uppercase()}
                    
        Your hard work and commitment to delivering food are
        always appreciated, and never forget... ${SLOGAN.uppercase()}.
        
        ...Thank you.
    """.trimIndent())
}

fun main() {
    startProgram(123, "Loch Ness Road")
}