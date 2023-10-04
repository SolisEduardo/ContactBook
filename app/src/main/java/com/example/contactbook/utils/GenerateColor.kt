package com.example.contactbook.utils

import kotlin.random.Random

class GenerateColor {
    operator fun invoke(): String {
        val red = Random.nextInt(150, 256)
        val green = Random.nextInt(150, 256)
        val blue = Random.nextInt(150, 256)

        return String.format("#%02X%02X%02X", red, green, blue)
    }
}