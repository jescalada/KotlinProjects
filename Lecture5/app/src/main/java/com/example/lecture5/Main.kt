package com.example.lecture5


fun main() {
    val restaurant = KrustyKrab()
    restaurant.reserveTable()
    restaurant.calculateFoodInventory()
    restaurant.processOrder()
    restaurant.prepareSpecialBurger()

    val cafe = BikiniBottomCafe(Restaurant())
    cafe.processOnlineOrder()
    cafe.calculateFoodInventory()
    cafe.processOrder()
}