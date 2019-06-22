package com.example.recall

import android.util.Log
import com.example.recall.Functions.longMax
import kotlin.math.abs

object Money {
    var amount: Long = 0 //main variable for money count
    var last: Long = 0 //saved money amount before operation
    var notEnough: Boolean = false

    fun set(number: Long) { //to set money for e.g. when loading from memory
        logS()
        saveLast()
        amount = number
        logE()
    }

    fun increase(number: Long) { //to increase in case of e.g. salary or decrease when e.g. buying something
        logS()
        saveLast()
        when {
            (amount + number) > longMax -> set(longMax)
            (amount + number) > 0 -> set(amount + number)
            else -> notEnough() //just additional safe thing
        }
        logE()
    }

    fun saveLast() {
        logS()
        last = amount //just to save money count before transaction
        logE()
    }

    fun isEnough(number: Long): Boolean { //to check if it's enough money to e.g. buy something
        return amount >= number
    }

    fun notEnough() { //to change status
        logS()
        notEnough = true
        logE()
    }

    fun format(money: Long): String =  //to format money before displaying it in textview
        when (abs(money)) {
            in 0 until 1000 -> ("$money $")
            in 1000 until 1000000 -> ((money / 1000).toString() + "," + ((money / 100) % 10).toString() + "K $")
            in 1000000 until 1000000000 -> ((money / 1000000).toString() + "," + ((money / 100000) % 10).toString() + "M $")
            in 1000000000 until 1000000000000 -> ((money / 1000000000).toString() + "," + ((money / 100000000) % 10).toString() + "B $")
            else -> (money.toString())
        }

    private fun logS() { //logs a function starting
        val name = Throwable().stackTrace[1].methodName
        val tM: String = "MoneyObject" //Log tag for Money object
        val ending: String = " function starts"
        Log.d(tM, (name + ending))
        if (BuildConfig.DEBUG) println("$tM: $name$ending")
    }

    private fun logE(){ //logs a function ending
        val name = Throwable().stackTrace[1].methodName
        val tM: String = "MoneyObject" //Log tag for Money object
        val ending: String = " function ends"
        Log.d(tM, (name + ending))
        if (BuildConfig.DEBUG) println("$tM: $name$ending")
    }

}