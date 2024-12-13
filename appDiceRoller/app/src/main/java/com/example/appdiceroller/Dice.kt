package com.example.appdiceroller

class Dice (val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}