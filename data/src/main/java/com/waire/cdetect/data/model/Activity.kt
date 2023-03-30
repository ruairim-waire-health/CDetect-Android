package com.waire.cdetect.data.model

data class Activity(
    val calories: String,
    val lastFall: String,
    val steps: String,
    val totalCalories: String,
    val activeCalories: String
) {
    constructor() : this(
        calories = "-",
        lastFall = "-",
        steps ="-",
        totalCalories = "-",
        activeCalories = "-"
    )
}
