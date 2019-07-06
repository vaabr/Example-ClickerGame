package com.example.recall

import com.example.recall.Functions.longMax
import org.junit.Assert.assertEquals
import org.junit.Test

class MoneyTest {
    @Test
    fun test() {
        var x = longMax
        x++
        println(x)
    }

    @Test
    fun increase_isCorrect() {
        val x = 700
        val y = 300
        val z = 5000
        Money.amount = 0
        Money.increase(x)
        assertEquals(x.toLong(), Money.amount)
        Money.increase(y)
        assertEquals(x.toLong(), Money.last)
        assertEquals((x+y).toLong(), Money.amount)
        Money.amount = longMax
        Money.increase(z)
        assertEquals(longMax, Money.amount)
        println(Money.amount)
    }

    @Test
    fun format_isCorrect(){
        Money.amount = Long.MAX_VALUE
        assertEquals("",Money.format())
    }
}