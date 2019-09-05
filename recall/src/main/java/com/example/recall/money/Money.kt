package com.example.recall.money

import android.util.Log
import com.example.recall.BuildConfig
import com.example.recall.Functions.loadLong
import com.example.recall.Functions.longMax
import com.example.recall.Functions.longMin
import com.example.recall.Functions.saveData
import kotlin.math.abs
import kotlin.math.pow

object Money {
    var amount: Long = 0 //main variable for money count
    var last: Long = 0 //saved money amount before operation
    private const val amountSaveName: String = "moneyAmountL"
    private const val lastSaveName: String = "moneyLastL"

    fun save() {
        saveData(
            amountSaveName,
            amount
        )
        saveData(lastSaveName, last)
    }

    fun load() {
        amount = loadLong(amountSaveName)
        last = loadLong(lastSaveName)
    }

    fun set(number: Long) { //to set money for e.g. when loading from memory
        logS()
        saveLast()
        amount = number
        logE()
    }

    fun increase(number: Int) { //to increase in case of e.g. salary or decrease when e.g. buying something
        logS()
        saveLast()
        number.toLong()
        when {
            ((amount + number) == (longMin + number - 2)) -> set(
                longMax
            )
            else -> set(amount + number)
        }
        logE()
    }

    private fun saveLast() {
        logS()
        last =
            amount //just to save money count before transaction
        logE()
    }

    fun format(): String { //to format money before displaying it in textview. Parameters letter according for this - https://idlechampions.gamepedia.com/Large_number_abbreviations
        logS()
        val ten = 10F
        val sign = "$"
        fun ten(x: Int) = ten.pow(x).toInt()
        fun returning(x: Int, letter: String, symbol: String) =
            ((amount / ten(x)).toString() + "," + ((amount / ten(x - 1)) % 10).toString() + "$letter $symbol")

        fun range(x: Int) = ten(x) until ten(x + 3)
        logE()
        return when (abs(amount)) {
            in 0 until ten(3) -> ("$amount $")
            in range(3) -> returning(3, "K", sign)
            in range(6) -> returning(6, "M", sign)
            in range(9) -> returning(9, "B", sign)
            in range(12) -> returning(12, "t", sign)
            in range(15) -> returning(15, "q", sign)
            in range(18) -> returning(18, "Q", sign)
            else -> (amount.toString())
        }
    }

    private fun logS() { //logs a function starting
        val name = Throwable().stackTrace[1].methodName
        val tM: String = "MoneyObject" //Log tag for Money object
        val ending: String = " function starts"
        Log.d(tM, (name + ending))
        if (BuildConfig.DEBUG) println("$tM: $name$ending")
    }

    private fun logE() { //logs a function ending
        val name = Throwable().stackTrace[1].methodName
        val tM: String = "MoneyObject" //Log tag for Money object
        val ending: String = " function ends"
        Log.d(tM, (name + ending))
        if (BuildConfig.DEBUG) println("$tM: $name$ending")
    }

}