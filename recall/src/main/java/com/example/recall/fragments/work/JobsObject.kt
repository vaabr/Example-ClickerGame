package com.example.recall.fragments.work

import com.example.recall.Functions
import com.example.recall.Stats
import com.example.recall.money.Money

object JobsObject {
    const val KEY_BEGGAR = "beggar"
    const val KEY_JANITOR = "janitor"
    private const val KEY_ERROR = "error"

    private val beggar = Job(1, " ", " ")
    private val janitor = Job(5, " ", " ")
    private val error = Job(0, "ERROR", "ERROR")

    val jobsMap = mapOf(KEY_ERROR to error, KEY_BEGGAR to beggar, KEY_JANITOR to janitor)

    fun setCurrent(key: String) {
        jobsMap.forEach { (_, v) -> v.makeCurrent(false) }
        jobsMap[key]?.makeCurrent(true)
    }

    fun findCurrent(): String {
        lateinit var result: String
        jobsMap.forEach { (t, u) -> if (u.isCurrent) result = t }
        return result
    }

    fun nullSafeFindCurrent(): Job = jobsMap[findCurrent()] ?: error

    fun doWork() {
        if (Stats.hungerStat - nullSafeFindCurrent().decreasedHunger >= 0) {
            Stats.increaseHunger(-(nullSafeFindCurrent().decreasedHunger))
            Money.increase(nullSafeFindCurrent().payment)
        }
    }

    fun saveCurrentJob() {
        Functions.saveData("Current Job", findCurrent())
    }

    fun loadCurrentJob() {
        setCurrent(Functions.loadString("Current Job") ?: KEY_BEGGAR)
    }
}