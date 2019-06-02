package com.example.recall

import com.example.recall.Functions.Money.countMultiplier
import org.junit.Assert.assertEquals
import org.junit.Test

class FunctionsTest {

    @Test
    fun countMultiplier_isCorrect(){
        for(g in 0..10){
            when(g){
                0 -> assertEquals(0, countMultiplier(0))
                1 -> assertEquals(1, countMultiplier(1000))
                2 -> assertEquals(1, countMultiplier(-5000))
                3 -> assertEquals(2, countMultiplier(1000000))
                4 -> assertEquals(2, countMultiplier(-5000000))
                5 -> assertEquals(3, countMultiplier(1000000000))
                6 -> assertEquals(0, countMultiplier(100))
                7 -> assertEquals(1, countMultiplier(20000))
                8 -> assertEquals(1, countMultiplier(150000))
                9 -> assertEquals(2, countMultiplier(1500000))
                10 -> assertEquals(2, countMultiplier(555555555))
            }
        }
    }
}