package com.example.contactbook.utils

import java.text.NumberFormat
import java.util.*
import kotlin.random.Random

class GenerateFormatMoney {
    operator fun invoke() : String{
        val numero = Random.nextInt(500, 100000) // Genera un número aleatorio entre 500 y 100,000

        val formatoMoneda = NumberFormat.getCurrencyInstance(Locale.US)
        return formatoMoneda.format(numero.toDouble())
    }
}