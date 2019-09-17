package com.example.recall.money

import com.example.recall.Functions.loadLong
import com.example.recall.Functions.longMax
import com.example.recall.Functions.longMin
import com.example.recall.Functions.saveData
import com.example.recall.log.L
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

    fun set(number: Long) {
        L.s()
        saveLast()
        amount = number
        L.e()
    }

    fun increase(number: Int) {
        L.s()
        saveLast()
        number.toLong()
        when {
            ((amount + number) == (longMin + number - 2)) -> set(
                longMax
            )
            else -> set(amount + number)
        }
        L.e()
    }

    private fun saveLast() {
        L.s()
        last = amount
        L.e()
    }

    fun format(): String {
        L.s()
        val ten = 10F
        val sign = "$"
        fun ten(x: Int) = ten.pow(x).toInt()
        fun returning(x: Int, letter: String, symbol: String) =
            ((amount / ten(x)).toString() + "," + ((amount / ten(x - 1)) % 10).toString() + "$letter $symbol")

        fun range(x: Int) = ten(x) until ten(x + 3)
        L.e()
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
}