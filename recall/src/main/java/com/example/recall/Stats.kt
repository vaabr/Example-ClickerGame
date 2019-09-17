package com.example.recall

object Stats {
    var happinessStat = 100
    var hungerStat = 100
    var healthStat = 100
    var rentStat = 10

    fun increaseHappiness(x: Int) {
        happinessStat = increaseStat(happinessStat, x)
    }

    fun increaseHunger(x: Int) {
        hungerStat = increaseStat(hungerStat, x)
    }

    fun increaseHealth(x: Int) {
        healthStat = increaseStat(healthStat, x)
    }

    fun increaseRent(x: Int) {
        if (rentStat + x >= 0) rentStat += x else rentStat = 0
    }

    fun formatHappiness(): String = "Happiness: $happinessStat"
    fun formatHunger(): String = "Hunger: $hungerStat"
    fun formatHealth(): String = "Health: $healthStat"
    fun formatRent(): String = "Rent: $rentStat clicks"

    private fun increaseStat(stat: Int, x: Int): Int {
        return when {
            (stat + x < 0) -> 0
            (stat + x > 100) -> 100
            else -> stat + x
        }
    }

}