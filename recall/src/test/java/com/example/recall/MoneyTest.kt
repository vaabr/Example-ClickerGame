package com.example.recall

import com.example.recall.Money.countMultiplier
import com.example.recall.Money.disassemble
import org.junit.Assert.assertEquals
import org.junit.Test

class MoneyTest {

    @Test
    fun countMultiplier_isCorrect(){
        assertEquals(0, countMultiplier(0))
        assertEquals(1, countMultiplier(1000))
        assertEquals(1, countMultiplier(-5000))
        assertEquals(2, countMultiplier(1000000))
        assertEquals(2, countMultiplier(-5000000))
        assertEquals(3, countMultiplier(1000000000))
        assertEquals(0, countMultiplier(100))
        assertEquals(1, countMultiplier(20000))
        assertEquals(1, countMultiplier(150000))
        assertEquals(2, countMultiplier(1500000))
        assertEquals(2, countMultiplier(555555555))
    }

    @Test
    fun disassemble_isCorrect(){
        var array = disassemble(5000)
        assertEquals(0, array[0])
        assertEquals(5, array[1])
        array = disassemble(1500700)
        assertEquals(700, array[0])
        assertEquals(500, array[1])
        assertEquals(1, array[2])
    }
}