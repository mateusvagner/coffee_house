package com.ifrs.coffeehouse.domain

data class Coffee(
    val id: Int,
    val name: String,
    val country: String,
    val roastingLevel: RoastingLevel
)
