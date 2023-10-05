package com.example.lecture5

open class Restaurant : POSSystem {
    override fun processOrder() {
        println("Processing order")
    }

    override fun calculateFoodInventory() {
        println("Calculating food inventory")
    }

    fun reserveTable() {
        println("Reserving table")
    }
}

class KrustyKrab : Restaurant() {
    fun prepareSpecialBurger() {
        println("Preparing special burger")
    }
}

class BikiniBottomCafe(private val posSystem: POSSystem) : POSSystem by posSystem {
    fun processOnlineOrder() {
        println("Processing online order")
    }

}