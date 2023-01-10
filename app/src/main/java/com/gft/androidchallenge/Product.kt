package com.gft.androidchallenge

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

data class Product(
    val id:String,
    val price: BigDecimal,
    val name: String,
    val image: String
)


fun BigDecimal.toCurrency(locale: Locale = Locale("pt", "BR")): String {
    val formatter = NumberFormat.getCurrencyInstance(locale)
    return formatter.format(this)
}