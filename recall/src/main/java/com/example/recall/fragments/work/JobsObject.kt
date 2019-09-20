package com.example.recall.fragments.work

import com.example.recall.Functions
import com.example.recall.stats.StatsObject
import com.example.recall.log.L
import com.example.recall.money.Money

object JobsObject {
    const val KEY_BEGGAR = "beggar"
    const val KEY_JANITOR = "janitor"
    private const val KEY_ERROR = "error"

    private val beggar = Job(1, " ", " ")
    private val janitor = Job(5, " ", " ")
    private val error = Job(0, "no job", "no job")

    val jobsMap = mapOf(KEY_ERROR to error, KEY_BEGGAR to beggar, KEY_JANITOR to janitor)
    val arrayOfKeys = arrayListOf(KEY_BEGGAR, KEY_JANITOR)

    fun setCurrent(key: String) {
        jobsMap.forEach { (_, v) -> v.makeCurrent(false) }
        jobsMap[key]?.makeCurrent(true)
    }

    fun findNameOfCurrent(): String? {
        L.s()
        var result: String? = null
        jobsMap.forEach { (t, u) -> if (u.isCurrent) result = t }
        return result
    }

    fun findCurrent(): Job = jobsMap[findNameOfCurrent()] ?: error

    fun doWork() {
        if (StatsObject.hungerStat - findCurrent().decreasedHunger >= 0) {
            StatsObject.increaseHunger(-(findCurrent().decreasedHunger))
            Money.increase(findCurrent().payment)
        }
    }

    fun saveCurrentJob() {
        Functions.saveData("Current Job", findNameOfCurrent() ?: KEY_BEGGAR)
    }

    fun loadCurrentJob() {
        L.s()
        setCurrent(Functions.loadString("Current Job") ?: KEY_BEGGAR)
    }
}