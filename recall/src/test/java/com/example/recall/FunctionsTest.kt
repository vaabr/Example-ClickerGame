package com.example.recall

import com.example.recall.Functions.Money.convertInc
import com.example.recall.Functions.Money.increaseMoney
import com.example.recall.Functions.Money.money
import com.example.recall.Functions.Money.multiplier
import org.junit.Assert.assertEquals
import org.junit.Test

class FunctionsTest {
    @Test
    fun convertInc_isCorrect() {
        money = 1005
        multiplier = 0
        convertInc()
        assertEquals(5, money)
        assertEquals(1, multiplier)
    }

    @Test
    fun increaseMoney_isCorrect() {
        money = 0
        multiplier = 0
        increaseMoney(1005)
        assertEquals(5, money)
        assertEquals(1, multiplier)
    }
}