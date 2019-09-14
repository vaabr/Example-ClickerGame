package com.example.recall

object Stats {
    var happinessStat = 100
    var hungerStat = 100
    var healthStat = 100
    var rentStat = 10

    fun increaseHappiness(x: Int){
        if ((happinessStat+x)<100&&(happinessStat+x)>=0) happinessStat+=x
    }

    fun increaseHunger(x: Int){
        if ((hungerStat+x)<100&&(hungerStat+x)>=0) hungerStat+=x
    }

    fun increaseHealth(x: Int){
        if ((healthStat+x)<100&&(healthStat+x)>=0) healthStat+=x
    }

    fun increaseRent(x: Int){
        rentStat+=x
    }

    fun formatHappiness(): String = "Happiness: $happinessStat"
    fun formatHunger(): String = "Hunger: $hungerStat"
    fun formatHealth(): String = "Health: $healthStat"
    fun formatRent(): String = "Rent: $rentStat clicks"

}